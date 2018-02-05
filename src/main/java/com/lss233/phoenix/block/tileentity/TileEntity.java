package com.lss233.phoenix.block.tileentity;

import com.lss233.phoenix.block.BlockState;

/**
 *
 */
public interface TileEntity {
    /**
     * Gets the BlockState that this TileEntity represents.
     * @return The blockstate
     */
    BlockState getBlock();
}
