package com.lss233.phoenix.event;

/**
 * Represents an event that can be cancelled.
 */
public interface Cancellable {

    /**
     * Whether the Event has been cancelled.
     *
     * @return Is the event cancelled.
     */
    boolean isCancelled();

    /**
     * Set the cancelled state of the Event.
     *
     * @param cancel Cancelled state.
     */
    void setCancelled(boolean cancel);
}
