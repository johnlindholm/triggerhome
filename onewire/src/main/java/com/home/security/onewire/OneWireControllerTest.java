package com.home.security.onewire;

import com.home.security.onewire.container.OneWireDevice;
import com.home.security.onewire.event.OneWireDeviceChangedEvent;
import com.home.security.onewire.event.OneWireEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class OneWireControllerTest implements OneWireEventListener {

    private final static Logger logger = LogManager.getLogger(OneWireControllerTest.class.getName());

    private OneWireController oneWireController;

    public OneWireControllerTest() {
        System.out.println("OneWireControllerTest.OneWireControllerTest");
        oneWireController = new OneWireController(this);
        oneWireController.start("rp2", OneWireController.DEFAULT_OWSERVER_PORT);
    }

    public static void main(String... args) {
//        new OneWireControllerTest();

        System.out.println("OneWireControllerTest.main " + UUID.nameUUIDFromBytes("ABC".getBytes()));
        if ("902fbdd2-b1df-3c4f-b0b4-a5d23525e932".equals(UUID.nameUUIDFromBytes("ABC".getBytes()).toString())) {
            System.out.println("OneWireControllerTest.main success!");
        }
    }

    @Override
    public void update(OneWireEvent oneWireEvent) {
        OneWireDevice oneWireDevice = oneWireEvent.getDevice();
        if (oneWireEvent instanceof OneWireDeviceChangedEvent) {
            OneWireDeviceChangedEvent oneWireDeviceChangedEvent = (OneWireDeviceChangedEvent) oneWireEvent;
            if (oneWireDeviceChangedEvent.getEventType() == OneWireDeviceChangedEvent.DEVICE_APPEARED) {
                logger.info("Device appeared: " + oneWireDevice.getOWFSDevicePath());
                //Device added
            } else {
                //Device removed
                logger.info("Device removed: " + oneWireDevice.getOWFSDevicePath());
            }
        }

    }
}