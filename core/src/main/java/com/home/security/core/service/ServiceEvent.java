package com.home.security.core.service;

/**
 * Created by john on 2014-12-30.
 */
public class ServiceEvent {

    public final static int TYPE_ADDED = 0;
    public final static int TYPE_REMOVED = 2;
    public final static int TYPE_UPDATED = 3;

    private final Service service;
    private final int type;

    public ServiceEvent(Service service, int type) {
        this.service = service;
        this.type = type;
    }

    public Service getService() {
        return service;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "service: " + service + ", eventType: " + typeToString();
    }

    private String typeToString() {
        switch (type) {
            case TYPE_ADDED:
                return "ADDED";
            case TYPE_REMOVED:
                return "REMOVED";
            case TYPE_UPDATED:
                return "UPDATED";
        }
        return null;
    }
}
