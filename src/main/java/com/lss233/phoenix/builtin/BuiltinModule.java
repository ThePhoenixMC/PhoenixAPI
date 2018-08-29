package com.lss233.phoenix.builtin;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.builtin.commands.PhoenixCommandExecutor;
import com.lss233.phoenix.builtin.listener.PhoenixEventListener;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.PhoenixModule;

/**
 *  The built-in module of Phoenix API
 */
@PhoenixModule(modid = "phoenix-builtin", name = "Phoenix Builtin", version = "1.0.0")
public class BuiltinModule extends Module{
    private final PhoenixCommandExecutor commandExecutor = new PhoenixCommandExecutor();
    private final PhoenixEventListener eventListener = new PhoenixEventListener();
    @Override
    public void onInitial() {
        Phoenix.getCommandManager().registerCommand(this, commandExecutor);
    }

    @Override
    public void onEnable() {
        Phoenix.getEventManager().registerListener(this, eventListener);
    }

    @Override
    public void onDisable() {
        Phoenix.getCommandManager().unregisterCommand(this, commandExecutor);
        Phoenix.getEventManager().unregisterListener(this, eventListener);
    }
}
