package com.lss233.phoenix.world;

import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.utils.Identifiable;

import java.util.List;
import java.util.UUID;

/**
 * A loaded Minecraft world.
 */
public interface World extends Identifiable{

    /**
     * Gets the name of this world.
     * @return The name of this world.
     */
    String getName();

    /**
     * Gets an list of Players currently in this world.
     * @return An collection of players currently in this world.
     */
    List<Player> getPlayers();

    /**
     * Gets the UUID of this world.
     * @return The UUID of this world.
     */
    UUID getUniqueId();

    /**
     * Gets the properties of the world.
     * @return The properties of this world.
     */
    WorldProperties getProperties();

    boolean equals(Object object);
}
