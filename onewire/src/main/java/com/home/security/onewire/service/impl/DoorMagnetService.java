package com.home.security.onewire.service.impl;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.ServiceId;
import com.home.security.onewire.container.OneWireContainer12;

/**
 * Created by john on 2015-01-26.
 */
public class DoorMagnetService extends AbstractService {

    private OneWireContainer12 oneWireDevice;

    public DoorMagnetService(String name, String version, CommunicationManager communicationManager, ServiceId serviceId) {
        super(name, version, communicationManager, serviceId);
    }

    @Override
    public void handleResponse(Response response) {

    }

    @Override
    public void stop() {

    }
}
