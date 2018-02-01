package com.lss233.phoenix.event.entity;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * Triggered when an {@link Event} is spawned.
 */
public interface SpawnEntityEvent extends AffectEntityEvent, Cancellable, Event {

    /**
     * Triggered when an {@link Event} is spawned by chunk loading.
     */
    interface ChunkLoad extends SpawnEntityEvent {

    }

    /**
     * Triggered when an {@link Event} is spawned by custom reason.
     */
    interface Custom extends SpawnEntityEvent {

    }

    /**
     * Triggered when an {@link Event} is spawned by a Spawner.
     */
    interface Spawner extends SpawnEntityEvent {

    }
}
