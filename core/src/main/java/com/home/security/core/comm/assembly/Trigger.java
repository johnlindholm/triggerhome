package com.home.security.core.comm.assembly;

import com.home.security.core.service.Service;

/**
 * Created by john on 2014-12-12.
 */
public class Trigger {

    public final static String ATTRIBUTE_SERVICE_ID = "serviceId";
    public final static String ATTRIBUTE_REQUEST_NAME = "requestName";

    private final Service triggerService;
    private final String triggerRequestName;
    private final AssemblyAction[] targetActions;

    public Trigger(Service triggerService, String triggerRequestName, AssemblyAction[] targetActions) {
        this.triggerService = triggerService;
        this.triggerRequestName = triggerRequestName;
        this.targetActions = targetActions;
    }

    public AssemblyAction[] getTargetActions() {
        return targetActions;
    }

    public Service getTriggerService() {
        return triggerService;
    }

    public String getTriggerRequestName() {
        return triggerRequestName;
    }
}
