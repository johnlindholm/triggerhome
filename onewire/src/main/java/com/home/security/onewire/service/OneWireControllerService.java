package com.home.security.onewire.service;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.ServiceId;
import com.home.security.onewire.OneWireController;
import com.home.security.onewire.OneWireEventListener;
import com.home.security.onewire.container.*;
import com.home.security.onewire.event.OneWireDeviceChangedEvent;
import com.home.security.onewire.event.OneWireEvent;

/**
 * Created by john on 2015-01-26.
 */
public class OneWireControllerService extends AbstractService implements OneWireEventListener {

    private OneWireController oneWireController;

    public OneWireControllerService(String name, String version, CommunicationManager communicationManager, ServiceId serviceId) {
        super(name, version, communicationManager, serviceId);
        init();
    }

    private void init() {
        oneWireController = new OneWireController(this);
        oneWireController.start("rp2", OneWireController.DEFAULT_OWSERVER_PORT);
    }

    @Override
    public void handleResponse(Response response) {

    }

    @Override
    public void stop() {
        oneWireController.stop();
    }

    @Override
    public void update(OneWireEvent oneWireEvent) {
        OneWireDevice oneWireDevice = oneWireEvent.getDevice();
        if (oneWireEvent instanceof OneWireDeviceChangedEvent) {
            OneWireDeviceChangedEvent oneWireDeviceChangedEvent = (OneWireDeviceChangedEvent) oneWireEvent;
            if (oneWireDeviceChangedEvent.getEventType() == OneWireDeviceChangedEvent.DEVICE_APPEARED) {

                //Device added
            } else {
                //Device removed
            }
        }

    }

    private boolean isAlreadyCreated(OneWireDevice oneWireDevice) {
        return false;
    }

    private void addNewDevice(OneWireDevice oneWireDevice) {
        if (oneWireDevice instanceof OneWireClockContainer) {

        }
        if (oneWireDevice instanceof OneWireContainersimultaneous) {

        }
        if (oneWireDevice instanceof OneWireContainerthermostat) {

        }
        if (oneWireDevice instanceof OneWireHumidityContainer) {

        }
        if (oneWireDevice instanceof OneWirePressureContainer) {

        }
        if (oneWireDevice instanceof OneWireSwitchContainer) {

        }
        if (oneWireDevice instanceof OneWireTemperatureContainer) {

        }
        if (oneWireDevice instanceof OneWireVoltageSensorContainer) {

        }
    }
}

