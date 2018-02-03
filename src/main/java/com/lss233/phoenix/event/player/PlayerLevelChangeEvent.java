package com.lss233.phoenix.event.player;

import com.lss233.phoenix.event.Event;

/**
 * Triggered when a  player's level change
 * Cause
 * <ul>
 *<li> player - the player </li>
 * </ul>
 */

public interface PlayerLevelChangeEvent extends Event {
    /**
     * Gets the new level of the human.
     * @return The new level of the human.
     */
    int getLevel();

    /**
     * Gets the original level of the human.
     * @return The original level of the human.
     */
    int getOriginalLevel();
}
