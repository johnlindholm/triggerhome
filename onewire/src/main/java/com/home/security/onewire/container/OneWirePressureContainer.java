package com.home.security.onewire.container;

import java.io.IOException;

public abstract interface OneWirePressureContainer {
    public abstract String getPressure()
            throws IOException;
}