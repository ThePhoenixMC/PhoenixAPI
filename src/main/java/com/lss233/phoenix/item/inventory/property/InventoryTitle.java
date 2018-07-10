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

package com.lss233.phoenix.item.inventory.property;

import com.lss233.phoenix.text.Text;

public class InventoryTitle implements InventoryProperty<String, Text> {
    public final static String PROPERTY_NAME = "title";
    private final Text text;

    /**
     * Creates a new InventoryTitle to be displayed on an Inventory.
     * @param text The text value to display
     */
    public InventoryTitle(Text text) {
        this.text = text;
    }

    /**
     * Creates a new InventoryTitle with the provided Text.
     * @param text The text value
     * @return The new inventory title
     */
    public static InventoryTitle of(Text text){
        return new InventoryTitle(text);
    }

    /**
     * Gets the title of this inventory.
     * @return The title.
     */
    public Text getText() {
        return text;
    }

    @Override
    public String getDefaultKey() {
        return PROPERTY_NAME;
    }
}
