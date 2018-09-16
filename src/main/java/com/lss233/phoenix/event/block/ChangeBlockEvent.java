package com.lss233.phoenix.event.block;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * Represents an event fired when the state of a Block changed.
 */
public interface ChangeBlockEvent extends Event, Cancellable {
    /**
     * Fired when a block is broken or moved.
     */
    interface Break extends ChangeBlockEvent {
    }

    /**
     * Fired when a block is decayed.
     */
    interface Decay extends ChangeBlockEvent {
    }

    /**
     * Fired when a block is grown.
     */
    interface Grow extends ChangeBlockEvent {
    }

    /**
     * Fired when a block type is modified
     */
    interface Modify extends ChangeBlockEvent {
    }

    /**
     * Fired when one or more {@link com.lss233.phoenix.block.Block}s are added to the {@link com.lss233.phoenix.world.World}.
     */
    interface Place extends ChangeBlockEvent {

    }

}
