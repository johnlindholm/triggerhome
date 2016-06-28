package com.home.security.core.protocol.utils;

import com.home.security.core.protocol.annotation.ServiceMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by john on 2014-12-15.
 */
public class ServiceMethodContainer {

    private ServiceMethod serviceMethod;
    private Method method;
    private ArrayList<ServiceMethodParamContainer> serviceMethodParamContainers;

    protected ServiceMethodContainer() {
    }

    public ServiceMethod getServiceMethod() {
        return serviceMethod;
    }

    public void setServiceMethod(ServiceMethod serviceMethod) {
        this.serviceMethod = serviceMethod;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public ArrayList<ServiceMethodParamContainer> getServiceMethodParamContainers() {
        return serviceMethodParamContainers;
    }

    public void setServiceMethodParamContainers(ArrayList<ServiceMethodParamContainer> serviceMethodParamContainers) {
        this.serviceMethodParamContainers = serviceMethodParamContainers;
    }
}
