package com.lss233.phoenix.builtin;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.builtin.commands.PhoenixCommandExecutor;
import com.lss233.phoenix.module.Module;
import com.lss233.phoenix.module.PhoenixModule;

/**
 *  The built-in module of Phoenix API
 */
@PhoenixModule(modid = "phoenix-builtin", name = "Phoenix Builtin", version = "1.0.0")
public class BuiltinModule extends Module{
    @Override
    public void onInitial() {
        Phoenix.getCommandManager().registerCommand(this, new PhoenixCommandExecutor());
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }
}
