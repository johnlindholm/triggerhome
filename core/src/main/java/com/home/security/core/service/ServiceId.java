package com.home.security.core.service;

import java.util.UUID;

/**
 * Created by john on 2014-11-29.
 */
public class ServiceId {

    public final UUID id;

    public ServiceId() {
        id = UUID.randomUUID();
    }

    public ServiceId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
