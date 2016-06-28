package com.home.security.core.service;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.message.Message;
import com.home.security.core.protocol.message.Request;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.protocol.utils.HostNameUtils;
import com.home.security.core.protocol.utils.MessageHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by john on 2014-11-23.
 */
public abstract class AbstractService implements Service {

    private final static Logger logger = LogManager.getLogger(AbstractService.class);
    protected final CommunicationManager communicationManager;
    private final ServiceId serviceId;
    private final String name;
    private final String version;
    private InetAddress ipAddress;

    public AbstractService(String name, String version, CommunicationManager communicationManager, ServiceId serviceId) {
        this.name = name;
        this.version = version;
        this.serviceId = serviceId;
        this.communicationManager = communicationManager;
        try {
            ipAddress = HostNameUtils.getLocalHostLANAddress();
        } catch (UnknownHostException e) {
            logger.error("Unable to get localhost!", e);
        }
    }

    public AbstractService(String name, String version, CommunicationManager communicationManager, ServiceId serviceId, InetAddress ipAddress) {
        this.name = name;
        this.version = version;
        this.serviceId = serviceId;
        this.communicationManager = communicationManager;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Response handleRequest(Request request) {
        return MessageHelper.executeRequest(this, request);
    }

    public Response sendBlockingRequest(Request request) {
        return communicationManager.sendBlockingRequest(request);
    }

    public Response sendBlockingRequest(Request request, long timeout) {
        return communicationManager.sendBlockingRequest(request, timeout);
    }

    public void sendNonBlockingMessage(Message message) {
        communicationManager.sendNonBlockingMessage(message);
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public abstract void handleResponse(Response response);

    @Override
    public String toString() {
        return "[" + this.getClass().getName() +
                "] name: " + name +
                ", serviceId: " + serviceId +
                ", version: " + version +
                ", ipAddress: " + ipAddress.getHostAddress();
    }

    public abstract void stop();
}
