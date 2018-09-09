package com.lss233.phoenix.event.item.inventory;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * Represents an event fired when a Living changed its inventory
 */
public interface ChangeInventoryEvent extends TargetInventoryEvent, Cancellable {
    /**
     * Fired when a Living changes it's equipment.
     */
    interface Equipment extends  ChangeInventoryEvent{

    }

    /**
     * Fired when a Living changes it's held ItemStack.
     */
    interface Held extends ChangeInventoryEvent{

    }

    /**
     * Fired when a Living picked up a ItemStack
     */
    interface Pickup extends ChangeInventoryEvent{

    }

    /**
     * Fired when an Inventory transfers items into another.
     */
    interface Transfer extends ChangeInventoryEvent {

    }
}
