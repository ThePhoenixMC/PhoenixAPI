package com.lss233.phoenix.entity.living;

import com.lss233.phoenix.channel.PluginMessageRecipient;
import com.lss233.phoenix.command.CommandSender;
import com.lss233.phoenix.entity.Equipable;
import com.lss233.phoenix.entity.LivingEntity;

/**
 * A Player represents the in-game entity of a human playing on a server.
 */
public interface Player extends LivingEntity, CommandSender, PluginMessageRecipient, Equipable {
    /**
     * Gets the player's last known username.
     * @return The player's last known username
     */
    String getName();

    /**
     * Kicks the player.
     */
    void kick();
}
