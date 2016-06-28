package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-12-30.
 */
public class Ping extends Message {

    public Ping(UUID messageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
    }

    public Ping(UUID messageId, long timestamp, InetAddress sourceIp, InetAddress destIp) {
        super(messageId, timestamp, sourceIp, new ServiceId(UUID.nameUUIDFromBytes(sourceIp.getAddress())), destIp, new ServiceId(UUID.nameUUIDFromBytes(destIp.getAddress())));
    }
}
