package com.lss233.phoenix.event.network;

import com.lss233.phoenix.event.Event;

/**
 * Represents an event fired during the login process.
 * The events are fired in the following order:
 * Auth -> Login -> Join -> Disconnect
 * Cause:
 * <ul>
 * <li> player - the player</li>
 * </ul>
 */
public interface ClientConnectionEvent extends Event {

    /**
     * Called asynchronously when the client attempts to authenticate against the server.
     */
    interface Auth extends ClientConnectionEvent{

    }
    /**
     * Called when a Player joins the game World for the first time after initial connection.
     */
    interface Join extends ClientConnectionEvent {
    }

    /**
     * Called after the client authenticates and attempts to login to the server.
     */
    interface Login extends ClientConnectionEvent {
    }

    /**
     * Called when a Player disconnects from the game.
     */
    interface Disconnect extends ClientConnectionEvent {

    }
}
