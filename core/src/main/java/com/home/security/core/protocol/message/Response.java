package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-11-23.
 */
public class Response extends Message {

    private final UUID requestMessageId;

    public Response(UUID messageId, UUID requestMessageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
        this.requestMessageId = requestMessageId;
    }

    public Response(UUID messageId, UUID requestMessageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId, Param... params) {
        super(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, params);
        this.requestMessageId = requestMessageId;
    }

    public UUID getRequestMessageId() {
        return requestMessageId;
    }

    @Override
    public String toString() {
        return "requestMessageId: " + requestMessageId + ", " + super.toString();
    }
}
