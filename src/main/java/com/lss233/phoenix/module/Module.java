package com.lss233.phoenix.module;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.config.json.JsonConfiguration;
import com.lss233.phoenix.logging.Logger;

import java.io.IOException;

/**
 *
 *
 */

@PhoenixModule(modid="Default",name="Default",version="FINAL")
public  abstract class Module {

    private State state = State.UNLOADED;

    /**
     * Call when module has been initialized.
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

    /**
     * Gets the default logger of this module.
     * @return The logger
     */
    private Logger getLogger() {
        return Phoenix.getLogger(ModuleManager.getModuleInfo(this).getName());
    }

    private JsonConfiguration getConfig() throws IOException {
        return Phoenix.getConfigurationManager().getConfig(this);
    }

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
