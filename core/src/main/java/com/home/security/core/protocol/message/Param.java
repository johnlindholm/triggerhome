package com.home.security.core.protocol.message;

/**
 * Created by john on 2014-11-25.
 */
public class Param {

    public final static String ATTRIBUTE_NAME = "name";
    public final static String ATTRIBUTE_TYPE = "type";

    public final static String PARAM_TYPE_BYTES = "bytes";
    public final static String PARAM_TYPE_INT = "int";
    public final static String PARAM_TYPE_LONG = "long";
    public final static String PARAM_TYPE_DOUBLE = "double";
    public final static String PARAM_TYPE_STRING = "string";
    public final static String PARAM_TYPE_BOOLEAN = "boolean";

    public final static String[] PARAM_TYPES = new String[]{PARAM_TYPE_BOOLEAN,
            PARAM_TYPE_STRING, PARAM_TYPE_BYTES, PARAM_TYPE_DOUBLE, PARAM_TYPE_INT, PARAM_TYPE_LONG};

    private String name;
    private Object value;

    public Param(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public Param(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "name: " + name + ", value: " + value;
    }
}
