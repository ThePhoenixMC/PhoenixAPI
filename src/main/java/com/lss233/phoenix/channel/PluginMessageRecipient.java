package com.lss233.phoenix.channel;

import com.lss233.phoenix.module.Module;

/**
 * .
 */
public interface PluginMessageRecipient {
    void sendPluginMessage(Module source, String channel, byte[] message);
}
