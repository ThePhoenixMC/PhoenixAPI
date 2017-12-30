package com.lss233.phoenix.logging;

import com.lss233.phoenix.Phoenix;

/**
 * .
 */
public class ModuleLogger implements Logger{
    private final String PREFIX;
    public ModuleLogger(String name) {
        PREFIX = name;
    }

    @Override
    public void info(String msg) {
        Phoenix.getServer().getLogger().info("["+PREFIX+"]"+msg);
    }

    @Override
    public void warn(String msg) {
        Phoenix.getServer().getLogger().warn("["+PREFIX+"]"+msg);
    }

    @Override
    public void debug(String msg) {
            Phoenix.getServer().getLogger().debug("["+PREFIX+"]"+msg);
    }
}
