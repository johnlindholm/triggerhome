package com.home.security.core.comm.assembly;

/**
 * Created by john on 2014-12-13.
 */
public class Repeat {

    public static final String ATTRIBUTE_INTERVAL = "interval";

    private final long interval;
    private final AssemblyAction targetAction;

    public Repeat(long interval, AssemblyAction targetAction) {
        this.interval = interval;
        this.targetAction = targetAction;
    }

    public AssemblyAction getTargetAction() {
        return targetAction;
    }

    public long getInterval() {
        return interval;
    }
}
