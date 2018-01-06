package com.lss233.phoenix.channel;

import com.lss233.phoenix.entity.living.Player;

/**
 * .
 */
public interface MessageListener {
    void onPluginMessageReceived(String channel, Player player, byte[] message);
}
