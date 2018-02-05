package com.lss233.phoenix.item.inventory;

/**
 * A Carrier is simply something that carries an Inventory.
 */
public interface Carrier {
    /**
     * Returns the inventory that this Carrier is holding.
     * @return The inventory that this Carrier is holding.
     */
    CarriedInventory<? extends Carrier>	getInventory();
}
