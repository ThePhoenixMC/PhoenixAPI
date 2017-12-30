package com.lss233.phoenix.event;


import com.lss233.phoenix.event.cause.Cause;

/**
 * Represents an event.
 */
public interface Event {
    /**
     * Get the cause of the Event.
     *
     * @return The cause of Event.
     */
    Cause getCause();
}
