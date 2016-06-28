package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.UUID;

/**
 * Created by john on 2014-12-30.
 */
public class VoidResponse extends Response {

    public VoidResponse(UUID messageId, UUID requestMessageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId) {
        super(messageId, requestMessageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId);
    }
}
