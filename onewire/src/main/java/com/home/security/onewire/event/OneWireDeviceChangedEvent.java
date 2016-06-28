package com.home.security.onewire.event;

import com.home.security.onewire.container.OneWireDevice;

public class OneWireDeviceChangedEvent
        implements OneWireEvent {
    public static final int DEVICE_APPEARED = 0;
    public static final int DEVICE_REMOVED = 1;
    private int eventType;
    private OneWireDevice device;

    public OneWireDeviceChangedEvent(int eventType, OneWireDevice device) {
        this.eventType = eventType;
        this.device = device;
    }

    public int getEventType() {
        return this.eventType;
    }

    public OneWireDevice getDevice() {
        return this.device;
    }
}