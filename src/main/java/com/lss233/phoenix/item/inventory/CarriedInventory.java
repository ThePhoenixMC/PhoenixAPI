package com.lss233.phoenix.item.inventory;

import com.lss233.phoenix.utils.Nameable;

import java.util.Optional;

/**
 * An Inventory which is owned or otherwise carried by a Carrier.
 */
public interface CarriedInventory<C extends Carrier> extends Inventory, Nameable{
    /**
     * Returns the Carrier of this Inventory.
     * @return The Carrier of this Inventory.
     */
    Optional<C> getCarrier();
}
