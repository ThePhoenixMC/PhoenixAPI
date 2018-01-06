package com.lss233.phoenix.world;

/**
 * Represents something with a location.
 */
public interface Locatable {
    /**
     * Gets the location of the source.
     * @return The location of the source.
     */
    Location getLocation();

    /**
     * Gets the world that this source resides in.
     * @return The world of the source.
     */
    World getWorld();
}
