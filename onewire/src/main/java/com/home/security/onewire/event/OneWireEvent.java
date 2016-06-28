package com.home.security.onewire.event;

import com.home.security.onewire.container.OneWireDevice;

public abstract interface OneWireEvent {
    public abstract OneWireDevice getDevice();
}