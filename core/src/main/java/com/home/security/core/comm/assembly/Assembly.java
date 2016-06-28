package com.home.security.core.comm.assembly;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.exception.AssemblyRunException;
import com.home.security.core.protocol.message.Param;
import com.home.security.core.protocol.message.Request;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by john on 2014-12-08.
 */
public class Assembly extends AbstractService implements ServiceEventListener {

    public final static String ATTRIBUTE_ID = "id";
    public final static String ATTRIBUTE_NAME = "name";
    public final static String ATTRIBUTE_VERSION = "version";
    public final static String VERSION = "1.0";
    public final static int STATE_OK = 0;
    public final static int STATE_NOT_OK = 1;
    private int state = STATE_NOT_OK;
    public final static int STATE_PARTIAL_OK = 2;
    private final static Logger logger = LogManager.getLogger(AbstractService.class.getName());
    private final static long REQUEST_TIMEOUT = 5000;
    private final AssemblyTriggerThread assemblyTriggerThread = new AssemblyTriggerThread();
    private final ArrayList<AssemblyRepeatThread> assemblyRepeatThreads = new ArrayList<AssemblyRepeatThread>();
    private final ArrayList<Repeat> repeatList;
    private final ArrayList<Trigger> triggerList;
    private final ArrayList<Service> serviceList;
    private final HashMap<UUID, Service> currentServiceIdServiceMap = new HashMap<UUID, Service>();
    private final HashMap<UUID, ArrayList<Trigger>> serviceIdTriggerListMap = new HashMap<UUID, ArrayList<Trigger>>();
    private final HashMap<UUID, String> requestMessageIdRequestNameMap = new HashMap<UUID, String>();
    private final ArrayBlockingQueue<Response> responseQueue = new ArrayBlockingQueue<Response>(1024);
    private final HashMap<UUID, ArrayList<Service>> serviceAlternatives;
    private final Universe universe = Universe.getUniverse();
    private boolean isRunning = false;
    private Init init;
    private Object lock = new Object();


    public Assembly(String version, String name, CommunicationManager communicationManager, ServiceId serviceId, ArrayList<Service> serviceList, Init init,
                    ArrayList<Trigger> triggerList, ArrayList<Repeat> repeatList, HashMap<UUID, ArrayList<Service>> serviceAlternatives) {
        super(name, version, communicationManager, serviceId);
        this.serviceAlternatives = serviceAlternatives;
        this.serviceList = serviceList;
        this.init = init;
        this.triggerList = triggerList;
        this.repeatList = repeatList;
        if (triggerList != null) {
            for (Trigger trigger : triggerList) {
                UUID id = trigger.getTriggerService().getServiceId().id;
                ArrayList<Trigger> triggers = serviceIdTriggerListMap.get(id);
                if (triggers == null) {
                    triggers = new ArrayList<Trigger>();
                }
                triggers.add(trigger);
                serviceIdTriggerListMap.put(id, triggers);
            }
        }
        for (Service service : serviceList) {
            logger.debug("Assembly.Assembly universe.registerListener service: " + service.getServiceId().id);
            universe.registerListener(this, service.getServiceId().id);
        }
        if (serviceAlternatives != null) {
            for (ArrayList<Service> list : serviceAlternatives.values()) {
                for (Service service : list) {
                    universe.registerListener(this, service.getServiceId().id);
                }
            }
        }
    }

    public HashMap<UUID, ArrayList<Service>> getServiceAlternatives() {
        return serviceAlternatives;
    }

    public int waitForStateOK() {
        if (state == STATE_OK) {
            return state;
        }
        synchronized (lock) {
            while (state != STATE_OK) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.debug("Assembly.waitForStateOK woke up");
        return state;
    }

    private void setState(int state) {
        synchronized (lock) {
            logger.debug("Assembly.setState state: " + state);
            this.state = state;
            lock.notifyAll();
        }
    }

    private void determineAndSetState() {
        logger.debug("Assembly.determineAndSetState");
        boolean foundAll = true;
        boolean foundAny = false;
        int index = 0;
        currentServiceIdServiceMap.clear();
        while (index < serviceList.size()) {
            Service serviceStub = serviceList.get(index);
            logger.debug("Assembly.determineAndSetState trying to find: " + serviceStub.getServiceId().id);
            boolean found = false;
            Service service = universe.getService(serviceStub.getServiceId().id);
            if (service == null) {
                ArrayList<Service> alternatives = serviceAlternatives.get(serviceStub.getServiceId().id);
                int altIndex = 0;
                while (alternatives != null && !found && altIndex < alternatives.size()) {
                    Service altServiceStub = alternatives.get(altIndex);
                    Service altService = universe.getService(altServiceStub.getServiceId().id);
                    if (altService != null) {
                        logger.debug("Assembly.determineAndSetState found alternative altService: " + serviceStub.getServiceId().id);
                        found = true;
                        currentServiceIdServiceMap.put(serviceStub.getServiceId().id, altService);
                    }
                    altIndex++;
                }
            } else {
                logger.debug("Assembly.determineAndSetState found service: " + service);
                found = true;
                currentServiceIdServiceMap.put(service.getServiceId().id, service);
            }
            foundAll &= found;
            foundAny |= found;
            index++;
        }
        if (foundAll) {
            setState(STATE_OK);
        } else if (foundAny) {
            setState(STATE_PARTIAL_OK);
        } else {
            setState(STATE_NOT_OK);
        }
    }

    public Init getInit() {
        return init;
    }

    public ArrayList<Trigger> getTriggerList() {
        return triggerList;
    }

    public ArrayList<Repeat> getRepeatList() {
        return repeatList;
    }

    public ArrayList<Service> getServiceList() {
        return serviceList;
    }

    public void start() throws AssemblyRunException {
        determineAndSetState();
        stop();
        isRunning = true;
        assemblyTriggerThread.start();
        assemblyRepeatThreads.clear();
        if (repeatList != null) {
            for (Repeat repeat : repeatList) {
                AssemblyRepeatThread assemblyRepeatThread = new AssemblyRepeatThread(repeat);
                assemblyRepeatThread.start();
                assemblyRepeatThreads.add(assemblyRepeatThread);
            }
        }
    }

    public void stop() {
        if (!isRunning) {
            return;
        }
        isRunning = false;
        assemblyTriggerThread.interrupt();
        try {
            assemblyTriggerThread.join();
        } catch (InterruptedException e) {
        }
        for (AssemblyRepeatThread assemblyRepeatThread : assemblyRepeatThreads) {
            assemblyRepeatThread.interrupt();
            try {
                assemblyRepeatThread.join();
            } catch (InterruptedException e) {
            }
        }
        assemblyRepeatThreads.clear();
    }

    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public void handleResponse(Response response) {
        responseQueue.add(response);
    }

    public void handleServiceEvent(ServiceEvent serviceEvent) {
        determineAndSetState();
    }

    public class AssemblyTriggerThread extends AssemblyThread {

        @Override
        public void run() {
            waitForStateOK();
            if (init != null) {
                for (AssemblyAction assemblyAction : init.getInitActions()) {
                    Request request = createRequest(assemblyAction);
                    while (request == null) {
                        //The remote service might be down, keep trying to send init action
                        logger.debug("AssemblyTriggerThread.run The remote service might be down, keep trying to send init action");
                        waitForStateOK();
                        request = createRequest(assemblyAction);
                    }
                    sendNonBlockingMessage(request);
                }
                while (isRunning && !isInterrupted()) {
                    waitForStateOK();
                    Response response = null;
                    try {
                        response = responseQueue.take();
                    } catch (InterruptedException e) {
                        continue;
                    }
                    String requestName = requestMessageIdRequestNameMap.remove(response.getRequestMessageId());
                    if (requestName != null) {
                        ArrayList<Trigger> triggers = serviceIdTriggerListMap.get(response.getSourceServiceId().id);
                        if (triggers != null) {
                            for (Trigger trigger : triggers) {
                                if (trigger.getTriggerRequestName().equals(requestName)) {
                                    for (AssemblyAction assemblyAction : trigger.getTargetActions()) {
                                        Request request = createRequest(response, assemblyAction);
                                        while (request == null) {
                                            //The remote service might be down, keep trying (with possibly different services)
                                            waitForStateOK();
                                            request = createRequest(response, assemblyAction);
                                        }
                                        logger.info("AssemblyTriggerThread Sending request: " + request);
                                        sendNonBlockingMessage(request);
                                    }
                                }
                            }
                        }
                    }
                }
                logger.debug(getId() + "_AssemblyTriggerThread.run exiting");
            }
        }
    }

    public class AssemblyRepeatThread extends AssemblyThread {

        private final Repeat repeat;

        public AssemblyRepeatThread(Repeat repeat) {
            this.repeat = repeat;
        }

        public void run() {
            long timeToSend = System.currentTimeMillis();
            while (isRunning && !isInterrupted()) {
                waitForStateOK();
                try {
                    while (System.currentTimeMillis() < timeToSend) {
                        sleep(timeToSend - System.currentTimeMillis());
                    }
                    Request request = createRequest(repeat.getTargetAction());
                    while (request == null) {
                        //The remote service might be down
                        continue;
                    }
                    Response response = sendBlockingRequest(request, REQUEST_TIMEOUT);
                    if (response == null) {
                        //The remote service might be down
                        continue;
                    }
                    responseQueue.put(response);
                    if (System.currentTimeMillis() > (timeToSend + repeat.getInterval())) {
                        timeToSend = System.currentTimeMillis();
                    } else {
                        timeToSend += repeat.getInterval();
                    }
                } catch (InterruptedException e) {
                }
            }
            logger.debug(getId() + "_AssemblyRepeatThread.run exiting");
        }
    }

    public abstract class AssemblyThread extends Thread {

        public abstract void run();

        public Request createRequest(Response response, AssemblyAction assemblyAction) {
            ServiceId serviceId = assemblyAction.getService().getServiceId();
            Service service = currentServiceIdServiceMap.get(serviceId.id);
            if (service == null) {
                return null;
            }
            ArrayList<Param> paramList = null;
            if (assemblyAction.getParams() != null) {
                paramList = new ArrayList<Param>();
                for (Param param : assemblyAction.getParams()) {
                    if (param instanceof TriggerParam) {
                        //Forward response param in request
                        String paramRefName = ((TriggerParam) param).getParamRefName();
                        Object value = null;
                        for (Param responseParam : response.getParamList()) {
                            if (responseParam.getName().equals(paramRefName)) {
                                value = responseParam.getValue();
                            }
                        }
                        param = new Param(param.getName(), value);
                    }
                    paramList.add(param);
                }
            }
            Request request = new Request(UUID.randomUUID(), System.currentTimeMillis(),
                    assemblyAction.getRequestName(),
                    getIpAddress(),
                    getServiceId(),
                    service.getIpAddress(),
                    service.getServiceId(),
                    paramList == null ? null : paramList.toArray(new Param[paramList.size()]));
            requestMessageIdRequestNameMap.put(request.getMessageId(), request.getName());
            return request;
        }

        public Request createRequest(AssemblyAction assemblyAction) {
            ServiceId serviceId = assemblyAction.getService().getServiceId();
            Service service = currentServiceIdServiceMap.get(serviceId.id);
            if (service == null) {
                return null;
            }

            Request request = new Request(UUID.randomUUID(), System.currentTimeMillis(),
                    assemblyAction.getRequestName(),
                    getIpAddress(),
                    getServiceId(),
                    service.getIpAddress(),
                    service.getServiceId(),
                    assemblyAction.getParams());
            requestMessageIdRequestNameMap.put(request.getMessageId(), request.getName());
            logger.debug("AssemblyThread.createRequest request: " + request);
            return request;
        }

    }
}
