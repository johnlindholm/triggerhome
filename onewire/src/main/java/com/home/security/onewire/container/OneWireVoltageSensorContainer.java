package com.home.security.onewire.container;

import java.io.IOException;

public abstract interface OneWireVoltageSensorContainer {
    public abstract String getVoltageAll()
            throws IOException;
}