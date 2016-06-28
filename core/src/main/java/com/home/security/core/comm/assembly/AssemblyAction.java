package com.home.security.core.comm.assembly;

import com.home.security.core.protocol.message.Param;
import com.home.security.core.service.Service;

/**
 * Created by john on 2014-12-15.
 */
public class AssemblyAction {

    public final static String ATTRIBUTE_REQUEST_NAME = "requestName";
    public final static String ATTRIBUTE_SERVICE_ID = "serviceId";

    private final Service service;
    private final String requestName;
    private final Param[] params;

    public AssemblyAction(Service service, String requestName, Param... params) {
        this.service = service;
        this.requestName = requestName;
        this.params = params;
    }

    public Service getService() {
        return service;
    }

    public String getRequestName() {
        return requestName;
    }

    public Param[] getParams() {
        return params;
    }
}
