package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-11-29.
 */
public class ErrorResponse extends Response {

    private String message;

    public ErrorResponse(UUID messageId, UUID requestMessageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId, String message) {
        super(messageId, requestMessageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
