package com.home.security.core.service;

import java.net.InetAddress;

/**
 * Created by john on 2014-12-16.
 */
public interface Service {

    public final static String ATTRIBUTE_SERVICE_ID = "serviceId";
    public final static String ATTRIBUTE_VERSION = "version";
    public final static String ATTRIBUTE_NAME = "name";
    public final static String ATTRIBUTE_IP_ADDRESS = "ipAddress";

    public ServiceId getServiceId();

    public String getName();

    public String getVersion();

    public InetAddress getIpAddress();
}
