package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-11-23.
 */
public class Request extends Message {

    public final static String ATTRIBUTE_REQUEST_NAME = "name";

    private String name;

    public Request(UUID messageId, long timestamp, String name, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
        this.name = name;
    }

    public Request(UUID messageId, long timestamp, String name, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId, Param... params) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, params);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + ", " + super.toString();
    }
}
