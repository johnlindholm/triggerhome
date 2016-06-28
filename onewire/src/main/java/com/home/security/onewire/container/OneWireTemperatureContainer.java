package com.home.security.onewire.container;

import java.io.IOException;

public abstract interface OneWireTemperatureContainer {
    public abstract String getTemperature()
            throws IOException;

    public abstract boolean hasTemperatureResolution();

    public abstract String getTemperatureHigh()
            throws IOException;

    public abstract void setTemperatureHigh(String paramString)
            throws IOException;

    public abstract String getTemperatureLow()
            throws IOException;

    public abstract void setTemperatureLow(String paramString)
            throws IOException;
}