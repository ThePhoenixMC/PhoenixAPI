package com.lss233.phoenix.channel;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.module.Module;

/**
 *
 */
public class ChannelManager {

    public ChannelManager() {
        if (Phoenix.getChannelManager() != null)
            throw new UnsupportedOperationException("CommandManager already defined.");
    }

    public void registerIncomingChannel(Module module, String channelName, MessageListener listener) {
        Phoenix.getServer().getInterface().getMessageChannelManager().registerIncomingPluginChannel(module, channelName, listener);
    }

    public void registerOutgoingChannel(Module module, String channelName) {
        Phoenix.getServer().getInterface().getMessageChannelManager().registerOutgoingPluginChannel(module, channelName);
    }
}
