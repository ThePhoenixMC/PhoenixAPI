package com.lss233.phoenix.event.player;


import com.lss233.phoenix.event.Event;

/**
 * Triggered when a Player Toggle Sneak Even.
 * <ul>
 * <li> player - the player</li>
 * </ul>
 */
public interface PlayerToggleSneakEven extends Event {
    boolean isSneaking();
}
