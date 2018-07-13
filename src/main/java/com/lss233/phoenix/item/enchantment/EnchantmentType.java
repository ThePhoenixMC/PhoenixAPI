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

package com.lss233.phoenix.item.enchantment;

public enum EnchantmentType {
    ;
    private final String name;
    private final int minLevel, maxLevel;
    private final boolean curse, treasure;

    EnchantmentType(String name, int minLevel, int maxLevel, boolean curse, boolean treasure) {
        this.name = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.curse = curse;
        this.treasure = treasure;
    }

    /**
     * Gets the name of this enchantment.
     * @return The name of this enchantment.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the minimum level that this Enchantment may had.
     * As know as <a href="https://hub.spigotmc.org/javadocs/spigot/org/bukkit/enchantments/Enchantment.html#getStartLevel">start level</a> in Bukkit.
     * @return The minimum level.
     */
    public int getMinLevel() {
        return minLevel;
    }

    /**
     * Gets the maximum level that this Enchantment may become.
     * @return The maximum level.
     */
    public int getMaxLevel() {
        return maxLevel;
    }

    /**
     * Gets whether or not this enchantment type is considered a "curse" enchantment.
     *
     * @return True if it is a "curse" enchantment.
     */
    public boolean isCurse() {
        return curse;
    }

    /**
     * Gets whether or not this enchantment type is considered a "treasure" enchantment.
     *
     * @return True if it is a "treasure" enchantment.
     */
    public boolean isTreasure() {
        return treasure;
    }
}
