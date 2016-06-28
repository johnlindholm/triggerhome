package com.home.security.core.protocol.utils;

import com.home.security.core.protocol.annotation.ServiceMethodParam;

/**
 * Created by john on 2014-12-15.
 */
public class ServiceMethodParamContainer {

    private ServiceMethodParam serviceMethodParam;
    private Class paramClass;

    protected ServiceMethodParamContainer() {
    }

    public ServiceMethodParam getServiceMethodParam() {
        return serviceMethodParam;
    }

    public void setServiceMethodParam(ServiceMethodParam serviceMethodParam) {
        this.serviceMethodParam = serviceMethodParam;
    }

    public Class getParamClass() {
        return paramClass;
    }

    public void setParamClass(Class paramClass) {
        this.paramClass = paramClass;
    }
}
