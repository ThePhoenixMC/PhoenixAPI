package com.lss233.phoenix.event.player;

import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.event.Event;
import com.lss233.phoenix.event.entity.TargetEntityEvent;

public interface TargetPlayerEvent extends TargetEntityEvent, Event {
    /**
     * Gets the target {@link Player}.
     * @return The player.
     */
    Player 	getTargetEntity();
}
