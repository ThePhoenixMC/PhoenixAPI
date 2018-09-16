/*
 * MIT License
 *
 * Copyright (c) 2018 PhoenixMC and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lss233.phoenix.event.item.inventory;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;
import com.lss233.phoenix.event.player.TargetPlayerEvent;
import com.lss233.phoenix.item.inventory.Inventory;
import com.lss233.phoenix.item.inventory.ItemStack;

import java.util.Optional;

/**
 * <p>Represents an event fired when a {@link Inventory} is clicked by a {@link com.lss233.phoenix.entity.living.Player}.</p>
 */
public interface ClickInventoryEvent extends TargetInventoryEvent, TargetPlayerEvent, Event, Cancellable {

    /**
     * Gets the result cursor after the click is done.
     * The returned value is mutable.
     * @return The result cursor.
     */
    Optional<ItemStack> getCursor();

    /**
     * Fired when a {@link com.lss233.phoenix.entity.living.Player} clicked
     * inventory in creative mode.
     */
    interface Creative extends ClickInventoryEvent {

    }

    /**
     * Fired when a {@link com.lss233.phoenix.entity.living.Player} dragged
     * a item to another slot.
     */
    interface Drag extends ClickInventoryEvent {

    }

    /**
     * Fired when a {@link Inventory} is clicked by
     * the middle mouse button, or a "scrollwheel click".
     */
    interface Middle extends ClickInventoryEvent {

    }
}
