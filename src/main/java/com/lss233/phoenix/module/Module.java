package com.lss233.phoenix.module;

/**
 *
 *
 */

@PhoenixModule(modid="Default",name="Default",version="FINAL")
public  abstract class Module {

    private State state = State.UNLOADED;

    /**
     * Call when module has been initaled.
     */
    public abstract void onInitial();
    
    /**
     * Call when module has been enabled.
     */
    public abstract void onEnable();
    
    /**
     *  Call when module has been disabled.
    */
    public abstract void onDisable();

    State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    enum State{
        LOADED, ENABLED, DISABLED, UNLOADED
    }
}
