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
    public void info(Object msg) {
        Phoenix.getServer().getLogger().info("["+PREFIX+"]"+msg);
    }

    @Override
    public void warn(Object msg) {
        Phoenix.getServer().getLogger().warn("["+PREFIX+"]"+msg);
    }

    @Override
    public void debug(Object msg) {
            Phoenix.getServer().getLogger().debug("["+PREFIX+"]"+msg);
    }

    @Override
    public void severe(Object msg) {
        Phoenix.getServer().getLogger().debug("["+PREFIX+"]"+msg);
    }
}
