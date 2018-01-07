package com.lss233.phoenix.event.entity;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;
import com.lss233.phoenix.world.Location;

/**
 * Triggered when a entity moved.
 * Cause:
 * <ul>
 * <li> entity - the entity</li>
 * <li> from - the location that the entity came from.</li>
 * <li> to - the location that the entity will change to.</li>
 * </ul>
 */
public interface MoveEntityEvent extends Event, Cancellable {
    /**
     * Sets the new transform that the {@link com.lss233.phoenix.entity.Entity} will change to.
     * @param location The new location.
     */
    void setTo(Location location);
}
