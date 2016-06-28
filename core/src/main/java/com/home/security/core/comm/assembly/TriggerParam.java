package com.home.security.core.comm.assembly;

import com.home.security.core.protocol.message.Param;

/**
 * Created by john on 2014-11-25.
 */
public class TriggerParam extends Param {

    public final static String ATTRIBUTE_PARAM_REF_NAME = "paramRefName";

    private String paramRefName;

    public TriggerParam(String name, String paramRefName) {
        super(name, null);
        this.paramRefName = paramRefName;
    }

    public TriggerParam(String name) {
        this(name, name);
    }

    public String getParamRefName() {
        return paramRefName;
    }
}
