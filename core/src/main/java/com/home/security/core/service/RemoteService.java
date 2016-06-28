package com.home.security.core.service;

import java.net.InetAddress;

/**
 * Created by john on 2014-12-12.
 */
public class RemoteService extends ServiceStub {

    public RemoteService(ServiceId serviceId, String name, String version, InetAddress ipAddress) {
        super(serviceId, name, version, ipAddress);
    }

    public RemoteService(ServiceStub serviceStub) {
        super(serviceStub.getServiceId(), serviceStub.getName(), serviceStub.getVersion(), serviceStub.getIpAddress());
    }

}
