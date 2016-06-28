package com.home.security.onewire.container;

import java.io.IOException;
import java.util.Date;

public abstract interface OneWireClockContainer {
    public abstract Date getDate()
            throws IOException;
}