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

import com.lss233.phoenix.math.Vector;

public class InventoryDimension implements InventoryProperty<String, Vector> {
    private final int width, height;
    public final static String PROPERTY_NAME = "dimension";

    public InventoryDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getDefaultKey() {
        return PROPERTY_NAME;
    }

    /**
     * Get the number of columns in this inventory.
     * @return The number of columns in this inventory.
     */
    public int getColumns() {
        return width;
    }

    /**
     * Get the number of rows in this inventory.
     * @return The number of rows in this inventory.
     */
    public int getRows() {
        return height;
    }
}
