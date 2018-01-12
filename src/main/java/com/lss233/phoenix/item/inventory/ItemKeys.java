package com.lss233.phoenix.item.inventory;

import com.lss233.phoenix.data.DataKey;

/**
 *
 */
public enum ItemKeys {

    ITEM_LORE(new DataKey("item lore"));

    private DataKey dataKey;
    private ItemKeys(DataKey dataKey) {
        this.dataKey = dataKey;
    }

    public DataKey getDataKey() {
        return dataKey;
    }
}
