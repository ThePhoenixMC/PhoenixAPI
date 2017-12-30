package com.lss233.phoenix.event.item.inventory;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;

/**
 * Represents an event fired when a Living changed its inventory
 * Cause:
 * <ul>
 *     <li>player - The player.</li>
 *     <li>item - The item.</li>
 * </ul>
 */
public interface ChangeInventoryEvent extends Event, Cancellable {
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
}
