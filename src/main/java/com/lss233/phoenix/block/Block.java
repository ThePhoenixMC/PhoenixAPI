package com.lss233.phoenix.block;

import com.lss233.phoenix.world.Location;

/**
 * .
 */
public interface Block {

    Location getLocation(Location location);

    BlockState getState(BlockState state);
}
