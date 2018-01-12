package com.lss233.phoenix.item.inventory;

import com.lss233.phoenix.data.DataKey;
import com.lss233.phoenix.data.value.ValueContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 */
public interface ItemStack extends ValueContainer {
    default ItemStack.Builder builder(){
        return new ItemStack.Builder();
    }
    ItemType getType();
    void setType(ItemType itemType);
    int getQuantity();
    void setQuantity(int quantity);
    default boolean equals(ItemStack itemStack){
        return itemStack != null &&
                getType().equals(itemStack.getType()) &&
                getValues().equals(itemStack.getValues());
    }

    public class Builder {
        ItemType itemType;
        int quantity = 100;
        Map<DataKey, Object> data = new HashMap<>();
        Builder instance = this;

        public ItemType getItemType() {
            return itemType;
        }

        public Builder setItemType(ItemType itemType) {
            this.itemType = itemType;
            return getInstance();
        }

        public Map<DataKey, Object> getData() {
            return data;
        }

        public Builder setData(Map<DataKey, Object> data) {
            this.data = data;
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
        public Builder add(ItemKeys key, Objects value){
            getData().put(key.getDataKey(), value);
            return getInstance();
        }
        public Builder remove(ItemKeys key){
            getData().remove(key.getDataKey());
            return getInstance();
        }

        public ItemStack build() {
            return new ItemStack() {
                @Override
                public ItemType getType() {
                    return getInstance().getItemType();
                }

                @Override
                public void setType(ItemType itemType) {
                    getInstance().setItemType(itemType);
                }

                @Override
                public int getQuantity() {
                    return getInstance().getQuantity();
                }

                @Override
                public void setQuantity(int quantity) {
                    getInstance().setQuantity(quantity);
                }

                @Override
                public Map<DataKey, Object> getData() {
                    return getInstance().getData();
                }
            };
        }

    }
}
