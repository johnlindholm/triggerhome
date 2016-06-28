package com.home.security.onewire;

import com.home.security.onewire.event.OneWireEvent;

public abstract interface OneWireEventListener {
    public abstract void update(OneWireEvent oneWireEvent);
}