package com.lss233.phoenix.item.inventory;

import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.data.key.Key;
import com.lss233.phoenix.data.key.Keys;
import com.lss233.phoenix.data.value.ValueContainer;

import java.util.*;

/**
 *
 */
public interface ItemStack extends ValueContainer {
    /**
     * Creates a new ItemStack.Builder to build an ItemStack.
     * @return A new ItemStack.Builder
     */
    static ItemStack.Builder builder(){
        return new ItemStack.Builder();
    }

    /**
     * Gets the ItemType of this ItemStack.
     * @return The type of this ItemStack.
     */
    ItemType getType();

    /**
     * Sets the ItemType of this ItemStack.
     * @param itemType The new ItemType.
     */
    void setType(ItemType itemType);

    /**
     * Gets the quantity of items in this stack,
     * as known as amount in Bukkit.
     * @return The quantity.
     */
    int getQuantity();

    /**
     * Sets the quantity of items in this stack,
     * as known as amount in Bukkit.
     * @param quantity The new quantity.
     */
    void setQuantity(int quantity);

    /**
     * Checks whether this item has the same ItemType,
     * quantity and data.
     * @param itemStack The ItemStack to compare
     * @return True if equal.
     */
    default boolean equals(ItemStack itemStack){
        return itemStack != null &&
                getType().equals(itemStack.getType()) &&
                getQuantity() == itemStack.getQuantity() &&
                getValues().equals(itemStack.getValues());
    }

    @Override
    default Set<Key<?>> getKeys() {
        return new HashSet<>(Arrays.asList(Keys.ITEM_DURABILITY, Keys.ITEM_ENCHANTMENTS, Keys.ITEM_LORE)); // Stupid idea.
    }

    @Override
    default Set<?> getValues() {
        Set<Object> values = new HashSet<>();
        getKeys().forEach(key -> get(key).ifPresent(values::add));
        return values;
    }

    class Builder {
        ItemType itemType;
        int quantity = 100;
        Map<Key, Object> values = new HashMap<>();
        Builder instance = this;

        public ItemType getItemType() {
            return itemType;
        }

        public Builder setItemType(ItemType itemType) {
            this.itemType = itemType;
            return getInstance();
        }


        public int getQuantity() {
            return quantity;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return getInstance();
        }

        public Builder getInstance() {
            return instance;
        }
        public Builder add(Key<?> key, Objects value){
            values.put(key, value);
            return getInstance();
        }
        public Builder remove(Key<?> key){
            values.remove(key);
            return getInstance();
        }

        public ItemStack build() {
            return Phoenix.getServer().getInterface().registerItemStack(this);
        }

    }
}
