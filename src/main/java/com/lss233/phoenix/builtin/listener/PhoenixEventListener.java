package com.lss233.phoenix.builtin.listener;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.event.EventHandler;
import com.lss233.phoenix.event.EventListener;
import com.lss233.phoenix.event.phoenix.PhoenixShutdownEvent;

/**
 *
 */
public class PhoenixEventListener implements EventListener {
    @EventHandler
    public void onPhoenixShuttingDown(PhoenixShutdownEvent event){
        Phoenix.getModuleManager().disableModules();
    }
}
