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

package com.lss233.phoenix.data.key;

import com.lss233.phoenix.item.enchantment.Enchantment;
import com.lss233.phoenix.text.Text;

import java.util.List;

public class Keys {
    public static final Key<Integer> ITEM_DURABILITY = Key.of("durability");

    public static final Key<List<Text>> ITEM_LORE = Key.of("lore");

    public static final Key<List<Enchantment>> ITEM_ENCHANTMENTS = Key.of("enchantments");

    public static final Key<Text> DISPLAY_NAME = Key.of("display_name");

}
