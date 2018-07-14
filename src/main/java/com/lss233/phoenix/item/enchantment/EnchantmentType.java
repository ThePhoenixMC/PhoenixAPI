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
    AQUA_AFFINITY("Aqua Affinity", 0, 1,2, false, false),
    BANE_OF_ARTHROPODS("Bane of Arthropods", 0, 5, 5, false, false),
    BLAST_PROTECTION("Blast Protection", 0, 4, 2, false, false),
    CHANNELING("Channeling", 0, 1, 1, false, false),
    CURSE_OF_BINDING("Curse of Binding", 0, 1, 1, false, false),
    CURSE_OF_VANISHING("Curse of Vanishing", 0, -1, -1, false, false),
    DEPTH_STRIDER("Depth Strider", 0, 3, 2, false, false),
    EFFICIENCY("Efficiency", 0, 5, 10, false, false),
    FEATHER_FALLING("Feather Falling", 0, 4, 5, false, false),
    FIRE_ASPECT("Fire Aspect", 0, 2, 2, false, false),
    FIRE_PROTECTION("Fire Protection", 0, 4, 5, false, false),
    FLAME("Flame", 0, 1, 2, false, false),
    FORTUNE("Fortune", 0, 3, 2, false, false),
    FROST_WALKER("Frost Walker", 0, 2, 2, false, false),
    IMPALING("Impaling", 0, 5, 2, false, false),
    INFINITY("Infinity", 0, 1, 1, false, false),
    KNOCKBACK("Knockback", 0, 2, 5, false, false),
    LOOTING("Looting", 0, 3, 2, false, false),
    LOYALTY("Loyalty", 0, 3, 5, false, false),
    LUCK_OF_THE_SEA("Luck of the Sea", 0, 3, 2, false, false),
    LURE("Lure", 0, 3, 2, false, false),
    MENDING("Mending", 0, 1, 2, false, false),
    POWER("Power", 0, 5, 10, false, false),
    PROJECTILE_PROTECTION("Projectile Protection", 0, 4, 5, false, false),
    PROTECTION("Protection", 0, 4, 10, false, false),
    PUNCH("Punch", 0, 2, 2, false, false),
    RESPIRATION("Respiration", 0, 3, 2, false, false),
    RIPTIDE("Riptide", 0, 3, 2, false, false),
    SHARPNESS("Sharpness", 0, 5, 10, false, false),
    SILK_TOUCH("Silk Touch", 0, 1, 1, false, false),
    SMITE("Smite", 0, 5, 5, false, false),
    SWEEPING_EDGE("Sweeping Edge", 0, 3, 2, false, false),
    THORNS("Thorns", 0, 3, 1, false, false),
    UNBREAKING("Unbreaking", 0, 3, 5, false, false);
    private final String name;
    private final int minLevel, maxLevel, weight;
    private final boolean curse, treasure;

    EnchantmentType(String name, int minLevel, int maxLevel, int weight, boolean curse, boolean treasure) {
        this.name = name;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.weight = weight;
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

    /**
     * Gets the weight of this enchantment.
     *
     * @return The weight
     */
    public int getWeight() {
        return weight;
    }
}
