package com.home.security.core.comm.assembly;

/**
 * Created by john on 2014-12-12.
 */
public class Init {

    private final AssemblyAction[] initActions;

    public Init(AssemblyAction[] initActions) {
        this.initActions = initActions;
    }

    public AssemblyAction[] getInitActions() {
        return initActions;
    }
}
