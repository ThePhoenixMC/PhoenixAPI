package com.lss233.phoenix.item.inventory.tileentity.carrier;

import com.lss233.phoenix.item.inventory.Carrier;
import com.lss233.phoenix.item.inventory.TileEntityInventory;

/**
 *
 */
public interface TileEntityCarrier extends Carrier{
    /**
     * Returns the inventory that this Carrier is holding.
     * @return The inventory this Carrier is holding
     */
    TileEntityInventory<TileEntityCarrier> getInventory();
}
