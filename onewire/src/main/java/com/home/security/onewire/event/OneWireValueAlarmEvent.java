package com.home.security.onewire.event;

import com.home.security.onewire.container.OneWireDevice;

public class OneWireValueAlarmEvent
        implements OneWireEvent {
    public static int ON_RISING = 0;

    public static int ON_DECLINING = 1;

    public static int ON_CHANGE = 2;
    private OneWireDevice device;
    private String fileName;
    private String newValue;
    private int alarmType = -1;
    private int id;

    public OneWireValueAlarmEvent(OneWireDevice device, String fileName, String newValue, int id) {
        this.device = device;
        this.fileName = fileName;
        this.newValue = newValue;
        this.id = id;
    }

    public int getAlarmType() {
        return this.alarmType;
    }

    public void setAlarmType(int type) {
        this.alarmType = type;
    }

    public String getNewValue() {
        return this.newValue;
    }

    public OneWireDevice getDevice() {
        return this.device;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getId() {
        return this.id;
    }
}