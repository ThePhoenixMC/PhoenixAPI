package com.lss233.phoenix.event.block;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * <p>Represents an event fired when the state of a Block changed.</p>
 */
public interface ChangeBlockEvent extends Event, Cancellable {
    /**
     * <p>Called when a block is broken.or moved.</p>
     * <p>Cause:</p>
     * <ul>
     *     <li>player - The Player that is breaking the block involved in this event.</li>
     * </ul>
     */
    interface Break extends  ChangeBlockEvent {}
    interface Decay extends  ChangeBlockEvent {}
    interface Grow extends  ChangeBlockEvent {}
    interface Modify extends  ChangeBlockEvent {}
}
