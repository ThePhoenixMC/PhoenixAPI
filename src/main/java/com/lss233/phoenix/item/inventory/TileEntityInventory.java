package com.lss233.phoenix.item.inventory;

import java.util.Optional;

/**
 * An Inventory which is owned by a TileEntity.
 */
public interface TileEntityInventory<T extends Carrier> extends CarriedInventory<T>{
    /**
     * Returns the owner of this Inventory.
     * @return This inventory's carrier
     */
    Optional<T> getTileEntity();
}
