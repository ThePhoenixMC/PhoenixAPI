package com.lss233.phoenix.event.entity;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

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
}
