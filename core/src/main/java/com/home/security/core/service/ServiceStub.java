package com.home.security.core.service;

import java.net.InetAddress;

/**
 * Created by john on 2014-12-12.
 */
public class ServiceStub implements Service {

    private ServiceId serviceId;
    private String name;
    private String version;
    private InetAddress ipAddress;

    public ServiceStub(ServiceId serviceId, String name, String version, InetAddress ipAddress) {
        this.serviceId = serviceId;
        this.name = name;
        this.version = version;
        this.ipAddress = ipAddress;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getName() +
                "] name: " + name +
                ", serviceId: " + serviceId +
                ", version: " + version +
                ", ipAddress: " + ipAddress.getHostAddress();
    }

}
