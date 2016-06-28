package com.home.security.core.protocol.message;

import com.home.security.core.service.Service;
import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-12-17.
 */
public class HeartAttack extends Message {

    private Service[] services;

    public HeartAttack(UUID messageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId, Service[] services) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
        this.services = services;
    }

    public Service[] getServices() {
        return services;
    }
}
