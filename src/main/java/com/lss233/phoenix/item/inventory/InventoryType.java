package com.lss233.phoenix.item.inventory;

/**
 * An enumeration of inventory types.
 */
public enum InventoryType {
    /**
     * A Anvil. 3 Slots.
     */
    ANVIL,
    /**
     * A Beacon. 1 Slots.
     */
    BEACON,
    /**
     * A BrewingStand. 5 Slots.
     */
    BREWING_STAND,
    /**
     * A Chest. Sizes from 9x1 to 9x6 are allowed. The default is 9x6.
     */
    CHEST,
    /**
     * A player's crafting inventory, with 4 CRAFTING slots , a RESULT slot and 4 ARMOR slot.
     *
     */
    CRAFTING,
    /**
     * Dispenser or Dropper. 3*3 Slots.
     */
    DISPENSER,
    /**
     * A Double chest. Sizes 9x1 to 9x6 are allowed. The default is 9x6.
     */
    DOUBLE_CHEST,
    /**
     * A Enchanting table. 2 Slots.
     */
    ENCHANTING_TABLE,
    /**
     * A Furnace. 3 Slots.
     */
    FURNACE,
    /**
     * A Hopper. 5x1 Slots.
     */
    HOPPER,
    /**
     * A Horse.  Donkey or Mule usually 2 Slots.
     */
    HORSE,
    /**
     * A Horse with chest. Usually a Donkey or Mule with Chest.
     * 2 Slots + 5x3 Chest.
     */
    HORSE_WITH_CHEST,
    /**
     * A player's inventory, with 9x1 hot bar, 9x3 main inventory, and 4
     * ARMOR slots.
     * <br />
     * Cannot be opened by server.
     */
    PLAYER,
    /**
     * A Villager. 3 Slots.
     */
    VILLAGER,
    /**
     * A Workbench. 3x3 + 1 Slots.
     */
    WORKBENCH,
}
