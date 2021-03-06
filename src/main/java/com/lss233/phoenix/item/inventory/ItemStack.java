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
     * Gets the maximum quantity per stack.
     * @return The max stack quantity of this item.
     */
    int getMaxStackQuantity();

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
        private ItemType itemType;
        private int quantity = 100;
        private Map<Key<?>, Object> values = new HashMap<>();

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
            return this;
        }
        public <E> Builder add(Key<E> key, E value){
            values.put(key, value);
            return getInstance();
        }
        public Builder remove(Key<?> key){
            values.remove(key);
            return getInstance();
        }

        public <E> Optional<E> get(Key<E> key){
            if(values.containsKey(key)){
                return Optional.of((E)values.get(key));
            } else
                return Optional.empty();
        }

        public ItemStack build() {
            return Phoenix.getServer().getInterface().registerItemStack(this);
        }

    }
}
