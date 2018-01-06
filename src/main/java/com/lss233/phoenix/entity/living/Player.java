package com.lss233.phoenix.entity.living;

import com.lss233.phoenix.OfflinePlayer;
import com.lss233.phoenix.channel.PluginMessageRecipient;
import com.lss233.phoenix.command.CommandSender;
import com.lss233.phoenix.entity.Entity;
import com.lss233.phoenix.entity.LivingEntity;

/**
 * A Player represents the in-game entity of a human playing on a server.
 */
public interface Player extends LivingEntity, OfflinePlayer, CommandSender, PluginMessageRecipient {
}
