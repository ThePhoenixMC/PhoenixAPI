package com.lss233.phoenix;

import java.util.List;
import java.util.UUID;

/**
 * .
 */
public interface World {
    String getName();

    List<Player> getPlayers();

    UUID getUUID();

    boolean equals(Object object);
}
