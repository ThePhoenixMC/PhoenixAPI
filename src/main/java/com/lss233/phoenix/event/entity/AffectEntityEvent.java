package com.lss233.phoenix.event.entity;

import com.lss233.phoenix.entity.Entity;
import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

import java.util.List;

/**
 * Triggered when {@link Event} is going to be affected.
 */
public interface AffectEntityEvent extends Event, Cancellable {
    /**
     * Gets the list of the entities who will be affected after this event.
     * @return The list of the entities who will be affected after this event.
     */
    List<Entity> getEntities();
}
