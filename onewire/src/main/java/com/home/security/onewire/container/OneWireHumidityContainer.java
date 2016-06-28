package com.home.security.onewire.container;

import java.io.IOException;

public abstract interface OneWireHumidityContainer {
    public abstract String getHumidity()
            throws IOException;
}