package com.home.security.onewire;

public class OneWireException extends Exception {
    private static final long serialVersionUID = 1L;

    public OneWireException() {
    }

    public OneWireException(String desc) {
        super(desc);
    }
}