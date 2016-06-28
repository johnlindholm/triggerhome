package com.home.security.core.comm.discovery;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.message.HeartAttack;
import com.home.security.core.protocol.message.HeartBeat;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-12-17.
 */
//TODO implement undiscovery when timedout
public class DiscoveryManagerService extends AbstractService implements ServiceEventListener, HeartBeatService {

    public final static String version = "1.0";
    private final static Logger logger = LogManager.getLogger(DiscoveryManagerService.class.getName());
    private static DiscoveryManagerService discoveryManagerService;
    private final long heartbeatInterval;
    private final InetAddress broadcastAddress;
    private Universe universe = Universe.getUniverse();
    private boolean isRunning = false;
    private HeartbeatThread heartbeatThread;

    private DiscoveryManagerService(CommunicationManager communicationManager, ServiceId serviceId, long heartbeatInterval, InetAddress broadcastAddress) {
        super("DiscoveryManagerService", version, communicationManager, serviceId);
        this.heartbeatInterval = heartbeatInterval;
        this.broadcastAddress = broadcastAddress;
    }

    public static DiscoveryManagerService getInstance(CommunicationManager communicationManager, ServiceId serviceId, long heartbeatInterval, InetAddress broadcastAddress) {
        if (discoveryManagerService == null) {
            discoveryManagerService = new DiscoveryManagerService(communicationManager, serviceId, heartbeatInterval, broadcastAddress);
        }
        return discoveryManagerService;
    }

    /**
     * @return null or a DiscoveryManagerService instance
     */
    public static DiscoveryManagerService tryGetInstance() {
        return discoveryManagerService;
    }

    public void start() throws IOException {
        logger.info("DiscoveryManagerService.start");
        if (isRunning) {
            stop();
        }
        isRunning = true;
        heartbeatThread = new HeartbeatThread();
        heartbeatThread.start();
    }

    @Override
    public void stop() {
        if (!isRunning) {
            return;
        }
        logger.info("DiscoveryManagerService.stop");
        isRunning = false;
        heartbeatThread.interrupt();
        try {
            heartbeatThread.join();
        } catch (InterruptedException e) {
        }
        for (Service service : universe.getLocalServices()) {
            sendNonBlockingMessage(createHeartattack(service));
        }
    }

    public void handleHeartbeat(HeartBeat heartBeat) {
        for (Service service : heartBeat.getServices()) {
            Service existingService = universe.getService(service.getServiceId().id);
            if (existingService == null) {
                logger.debug("DiscoveryManagerService.handleHeartbeat found new service: " + service);
                universe.addService(new RemoteService((ServiceStub) service));
            } else if (!(existingService instanceof AbstractService)) {
                //Received possibly updated service, replace if newer version
                if (isNewerVersion(existingService.getVersion(), service.getVersion())) {
                    logger.debug("DiscoveryManagerService.handleHeartbeat found newer version of service: " + service);
                    universe.updateService(service);
                }
            }
        }
    }

    private boolean isNewerVersion(String oldVersion, String newVersion) {
        Double oldValue = Double.parseDouble(oldVersion);
        Double newValue = Double.parseDouble(newVersion);
        return newValue > oldValue;
    }


    public void handleHeartattack(HeartAttack heartAttack) {
        for (Service service : heartAttack.getServices()) {
            if (universe.getService(service.getServiceId().id) != null) {
                universe.removeService(service.getServiceId().id);
            }
        }
    }

    @Override
    public void handleResponse(Response response) {

    }

    private synchronized HeartBeat createHeartbeat() {
        return new HeartBeat(UUID.randomUUID(), System.currentTimeMillis(), getIpAddress(),
                getServiceId(), broadcastAddress, null, universe.getLocalServices());
    }

    private synchronized HeartAttack createHeartattack(Service service) {
        logger.debug("DiscoveryManagerService.createHeartattack for service: " + service);
        return new HeartAttack(UUID.randomUUID(), System.currentTimeMillis(), getIpAddress(),
                getServiceId(), broadcastAddress, null, new Service[]{service});
    }

    @Override
    public void handleServiceEvent(ServiceEvent serviceEvent) {
        switch (serviceEvent.getType()) {
            case ServiceEvent.TYPE_ADDED:
                sendNonBlockingMessage(createHeartbeat());
                break;
            case ServiceEvent.TYPE_UPDATED:
                sendNonBlockingMessage(createHeartbeat());
                break;
            case ServiceEvent.TYPE_REMOVED:
                sendNonBlockingMessage(createHeartattack(serviceEvent.getService()));
                break;
        }
    }

    public class HeartbeatThread extends Thread {
        public void run() {
            long sendTime = System.currentTimeMillis();
            while (isRunning && !isInterrupted()) {
                sendNonBlockingMessage(createHeartbeat());
                sendTime += heartbeatInterval;
                while (isRunning && !isInterrupted() && System.currentTimeMillis() < sendTime) {
                    try {
                        sleep(sendTime - System.currentTimeMillis());
                    } catch (InterruptedException e) {
                    }
                }
            }
            logger.debug(getId() + "_HeartbeatThread.run exiting");
        }
    }
}
