package com.lss233.phoenix.block.tileentity.carrier;

import com.lss233.phoenix.item.inventory.Carrier;
import com.lss233.phoenix.item.inventory.TileEntityInventory;
import com.lss233.phoenix.block.tileentity.TileEntity;

/**
 *
 */
public interface TileEntityCarrier extends TileEntity,Carrier{
    /**
     * Returns the inventory that this Carrier is holding.
     * @return The inventory this Carrier is holding
     */
    TileEntityInventory<TileEntityCarrier> getInventory();
}
