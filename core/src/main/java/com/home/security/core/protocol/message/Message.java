package com.home.security.core.protocol.message;

import com.home.security.core.service.ServiceId;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by john on 2014-11-23.
 */
public abstract class Message {

    public final static String TYPE_REQUEST = "request";
    public final static String TYPE_RESPONSE = "response";
    public final static String TYPE_HEARTBEAT = "heartbeat";
    public final static String TYPE_HEARTATTACK = "heartattack";
    public final static String TYPE_PING = "ping";

    public final static String ATTRIBUTE_MESSAGE_SOURCE_IP = "source_ip";
    public final static String ATTRIBUTE_MESSAGE_DESTINATION_IP = "dest_ip";
    public final static String ATTRIBUTE_MESSAGE_VERSION = "version";
    public final static String ATTRIBUTE_MESSAGE_ID = "message_id";
    public final static String ATTRIBUTE_MESSAGE_TYPE = "type";
    public final static String ATTRIBUTE_MESSAGE_SOURCE_SERVICE_ID = "source_service_id";
    public final static String ATTRIBUTE_MESSAGE_DEST_SERVICE_ID = "dest_service_id";

    public final static String VERSION = "1.0";
    private final InetAddress sourceIp;
    private final InetAddress destIp;
    private final ServiceId sourceServiceId;
    private final ServiceId destServiceId;
    private final UUID messageId;
    private long timestamp;
    private ArrayList<Param> paramList = new ArrayList();

    public Message(UUID messageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId) {
        this(messageId, timestamp, sourceIp, sourceServiceId, destIp, destServiceId, null);
    }

    public Message(UUID messageId, long timestamp, InetAddress sourceIp, ServiceId sourceServiceId, InetAddress destIp, ServiceId destServiceId, Param... params) {
        this.messageId = messageId;
        this.sourceIp = sourceIp;
        this.destIp = destIp;
        this.timestamp = timestamp;
        this.sourceServiceId = sourceServiceId;
        this.destServiceId = destServiceId;
        if (params != null) {
            paramList = new ArrayList(Arrays.asList(params));
        }
    }

    public UUID getMessageId() {
        return messageId;
    }

    public ServiceId getSourceServiceId() {
        return sourceServiceId;
    }

    public ServiceId getDestServiceId() {
        return destServiceId;
    }

    public InetAddress getSourceIp() {
        return sourceIp;
    }

    public InetAddress getDestIp() {
        return destIp;
    }

    public ArrayList<Param> getParamList() {
        return paramList;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        String params = null;
        for (Param param : paramList) {
            if (param == null) {
                break;
            } else if (params == null) {
                params = "(" + param.toString() + ")";
            } else {
                params += ", (" + param.toString() + ")";
            }
        }
        return "[" + this.getClass().getName() + "]" +
                " timestamp: " + timestamp +
                ", sourceIp: " + (sourceIp == null ? "" : sourceIp.getHostAddress()) +
                ", sourceServiceId: " + (sourceServiceId == null ? "" : sourceServiceId.id) +
                ", destIp: " + (destIp == null ? "" : destIp.getHostAddress()) +
                ", destServiceId: " + (destServiceId == null ? "" : destServiceId.id) +
                ", params: (" + params + ")";
    }
}
