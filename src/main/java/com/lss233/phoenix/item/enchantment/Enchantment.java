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

import com.lss233.phoenix.Phoenix;

public interface Enchantment {

    /**
     * Creates a new Enchantment.Builder to create an Enchantment.
     * @return The new Enchantment.Builder
     */
    static Enchantment.Builder builder(){
        return new Builder();
    }

    /**
     * Gets the level of this enchantment.
     * @return The level.
     */
    int getLevel();

    /**
     * Gets the type of this enchantment.
     * @return The type.
     */
    EnchantmentType	getType();

    class Builder {
        private int level;
        private EnchantmentType type;
        /**
         * Builds an instance of a Enchantment.
         * @return An Enchantment instance.
         */
        public Enchantment build(){
            return Phoenix.getServer().getInterface().registerEnchantment(this);
        }

        /**
         * Gets the level of this Enchantment.
         * @return The level.
         */
        public int getLevel() {
            return level;
        }

        /**
         * Sets the level of this Enchantment.
         * @param level The level
         * @return The Builder instance.
         */
        public Builder setLevel(int level) {
            this.level = level;
            return this;
        }

        /**
         * Gets the type of this Enchantment.
         * @return The type.
         */
        public EnchantmentType getType() {
            return type;
        }

        /**
         * Sets the type of this Enchantment.
         * @param type The type.
         * @return The Builder instance.
         */
        public Builder setType(EnchantmentType type) {
            this.type = type;
            return this;
        }
    }
}
