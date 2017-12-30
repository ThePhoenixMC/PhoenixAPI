package com.lss233.phoenix.event.player;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * Triggered when a  player's level change
 * Cause
 * <ul>
 *<li> player - the player </li>
 * </ul>
 */

public interface PlayerLevelChangeEvent extends Event,Cancellable
{

}
