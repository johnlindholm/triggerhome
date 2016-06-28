package com.home.security.core.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by john on 2014-12-02.
 */
public class Universe {

    private final static Logger logger = LogManager.getLogger(Universe.class.getName());

    private static Universe universe = null;
    private final EventTread eventTread;
    private ConcurrentHashMap<UUID, Service> services = new ConcurrentHashMap<UUID, Service>();
    private ArrayList<ServiceEventListener> listeners = new ArrayList<ServiceEventListener>();
    private HashMap<UUID, ArrayList<ServiceEventListener>> serviceUUIDListenersMap = new HashMap<UUID, ArrayList<ServiceEventListener>>();
    private ArrayBlockingQueue<ServiceEvent> serviceEvents = new ArrayBlockingQueue<ServiceEvent>(1024);
    private boolean isRunning = false;

    private Universe() {
        isRunning = true;
        eventTread = new EventTread();
        eventTread.start();
    }

    public static Universe getUniverse() {
        if (universe == null) {
            universe = new Universe();
        }
        return universe;
    }

    public Service getService(UUID id) {
        return services.get(id);
    }

    public Service[] getServices() {
        return services.values().toArray(new Service[services.values().size()]);
    }

    public Service[] getLocalServices() {
        ArrayList<Service> localServices = new ArrayList<Service>();
        for (Service service : services.values()) {
            if (service instanceof AbstractService) {
                localServices.add(service);
            }
        }
        return localServices.toArray(new Service[localServices.size()]);
    }

    public Service[] getServices(InetAddress address) {
        ArrayList<Service> serviceList = new ArrayList<Service>();
        for (Service service : services.values()) {
            if (service.getIpAddress().equals(address)) {
                serviceList.add(service);
            }
        }
        return serviceList.toArray(new Service[serviceList.size()]);
    }

    public void addService(Service service) {
        Service existingService = getService(service.getServiceId().id);
        if (existingService != null) {
            //Already exists
            if (existingService.getVersion().equals(service.getVersion())) {
                //Nothing new...
                return;
            } else {
                //Updated
                updateService(service);
            }
        } else {
            logger.debug("addService: name: " + service.getName() + ", id: " + service.getServiceId().id + ", ip: " + service.getIpAddress());
            services.put(service.getServiceId().id, service);
            serviceEvents.add(new ServiceEvent(service, ServiceEvent.TYPE_ADDED));
        }
    }

    public void removeService(UUID id) {
        Service service = services.remove(id);
        if (service != null) {
            logger.debug("removeService: " + id);
            if (service instanceof AbstractService) {
                ((AbstractService) service).stop();
            }
            serviceEvents.add(new ServiceEvent(service, ServiceEvent.TYPE_REMOVED));
        }
    }

    public void updateService(Service service) {
        Service existingService = getService(service.getServiceId().id);
        if (existingService == null) {
            //new service...
            addService(service);
        } else {
            services.put(service.getServiceId().id, service);
            serviceEvents.add(new ServiceEvent(service, ServiceEvent.TYPE_UPDATED));
        }
    }

    public void registerListener(ServiceEventListener serviceEventListener) {
        for (UUID id : services.keySet()) {
            unregisterListener(serviceEventListener, id);
        }
        if (!listeners.contains(serviceEventListener)) {
            listeners.add(serviceEventListener);
        }
    }

    public void registerListener(ServiceEventListener serviceEventListener, UUID id) {
        if (listeners.contains(serviceEventListener)) {
            //Will receive events for all services...
            return;
        }
        ArrayList<ServiceEventListener> list = serviceUUIDListenersMap.get(id);
        if (list == null) {
            list = new ArrayList<ServiceEventListener>();
        }
        if (!list.contains(serviceEventListener)) {
            logger.debug("Universe.registerListener listener: " + serviceEventListener + ", id: " + id);
            list.add(serviceEventListener);
            serviceUUIDListenersMap.put(id, list);
        }
    }

    public void unregisterListener(ServiceEventListener serviceEventListener) {
        listeners.remove(serviceEventListener);
    }

    public void unregisterListener(ServiceEventListener serviceEventListener, UUID id) {
        ArrayList<ServiceEventListener> list = serviceUUIDListenersMap.get(id);
        if (list != null) {
            list.remove(serviceEventListener);
        }
    }

    public void stop() {
        for (Service service : getLocalServices()) {
            removeService(service.getServiceId().id);
        }
        isRunning = false;
        eventTread.interrupt();
        try {
            eventTread.join();
        } catch (InterruptedException e) {
            //Ignore
        }
    }

    private class EventTread extends Thread {
        public void run() {
            while (isRunning && !isInterrupted()) {
                try {
                    ServiceEvent serviceEvent = serviceEvents.take();
                    logger.debug("EventTread.run serviceEvent: " + serviceEvent);
                    ArrayList<ServiceEventListener> list = serviceUUIDListenersMap.get(serviceEvent.getService().getServiceId().id);
                    if (list != null) {
                        for (ServiceEventListener listener : list) {
                            listener.handleServiceEvent(serviceEvent);
                        }
                    }
                    for (ServiceEventListener listener : listeners) {
                        listener.handleServiceEvent(serviceEvent);
                    }
                } catch (InterruptedException e) {
                    //Ignore
                }
            }
        }
    }
}
