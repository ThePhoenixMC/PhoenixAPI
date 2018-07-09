package com.lss233.phoenix.entity.living;

import com.lss233.phoenix.channel.PluginMessageRecipient;
import com.lss233.phoenix.command.CommandSender;
import com.lss233.phoenix.entity.Equipable;
import com.lss233.phoenix.entity.LivingEntity;
import com.lss233.phoenix.item.inventory.Inventory;

import java.util.Optional;

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

    /**
     * Opens the given Inventory for the player.
     * @param inventory The inventory.
     */
    Optional<Inventory> openInventory(Inventory inventory);

    /**
     * Gets the Inventory which the player is viewing.
     */
    Optional<Inventory> getOpenInventory();

    /**
     * Closes the currently viewed Inventory of this player.
     * @return whether the Inventory is successfully closed.
     */
    boolean closeInventory();
}
