package com.home.security.onewire.container;

import java.io.IOException;

public interface OneWireSwitchContainer {

    boolean isOn() throws IOException;

    void turnAllOn() throws IOException;

    void turnAllOff() throws IOException;
}