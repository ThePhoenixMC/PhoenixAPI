package com.lss233.phoenix.entity;

import com.lss233.phoenix.item.inventory.Carrier;
import com.lss233.phoenix.item.inventory.ItemStack;
import com.lss233.phoenix.item.inventory.equipment.EquipmentType;
import com.lss233.phoenix.utils.Identifiable;

import javax.annotation.Nullable;
import java.util.Optional;

/**
 * Represents an entity that has an EquipmentInventory.
 */
public interface Equipable extends Identifiable, Carrier {

    /**
     * Sets the item currently equipped by the entity in the specified slot,
     * if the entity has such a slot.
     * <p>
     *     Supplying null to {@code itemStack} will remove currently equipped item.
     * </p>
     * @param type The type of equipment slot to set
     * @param itemStack The equipment to set or null to remove any equipped item
     * @return True if the item was successfully equipped
     */
    boolean equip(EquipmentType type, @Nullable  ItemStack itemStack);

    /**
     * Gets the item currently equipped by this entity in the specified slot.
     * @param type The type of equipment slot
     * @return The item in the equipped slot
     */
    Optional<ItemStack> getEquipped(EquipmentType type);

    /**
     * Gets the boots currently being worn by this entity.
     * @return The boots
     */
    default Optional<ItemStack> getBoots(){
        return getEquipped(EquipmentType.BOOTS);
    }

    /**
     * Gets the chest plate currently being worn by this entity.
     * @return The chest plate
     */
    default Optional<ItemStack> getChestplate(){
        return getEquipped(EquipmentType.CHESTPLATE);
    }

    /**
     * Gets the helmet currently being worn by this entity.
     * @return The helmet
     */
    default Optional<ItemStack> getHelmet(){
        return getEquipped(EquipmentType.HEADWEAR);
    }

    /**
     * Gets the leggings currently being worn by this entity.
     * @return The leggings
     */
    default Optional<ItemStack> getLeggings(){
        return getEquipped(EquipmentType.LEGGINGS);
    }

    /**
     * Gets the item the entity is currently holding in their main hand.
     * @return The item.
     */
    default Optional<ItemStack> getItemInMainHand(){
        return getEquipped(EquipmentType.MAIN_HAND);
    }

    /**
     * Gets the item the entity is currently holding in their off hand.
     * @return The item.
     */
    default Optional<ItemStack> getItemInOffHand(){
        return getEquipped(EquipmentType.OFF_HAND);
    }

    /**
     * Sets the boots currently being worn by this entity.
     * @param itemStack The boots, using null to remove.
     */
    default void setBoots(@Nullable ItemStack itemStack){
        equip(EquipmentType.BOOTS, itemStack);
    }

    /**
     * Sets the chest plate currently being worn by this entity.
     * @param itemStack The chest plate, using null to remove.
     */
    default void setChestplate(@Nullable ItemStack itemStack){
        equip(EquipmentType.CHESTPLATE, itemStack);
    }

    /**
     * Sets the helmet currently being worn by this entity.
     * @param itemStack The helmet, using null to remove.
     */
    default void setHelmet(@Nullable ItemStack itemStack){
        equip(EquipmentType.HEADWEAR, itemStack);
    }

    /**
     * Sets the leggings currently being worn by this entity.
     * @param itemStack The leggings, using null to remove.
     */
    default void setLeggings(@Nullable ItemStack itemStack){
        equip(EquipmentType.LEGGINGS, itemStack);
    }

    /**
     * Sets the item currently being held in main hand by this entity.
     * @param itemStack The item, using null to remove.
     */
    default void setItemInMainHand(@Nullable ItemStack itemStack){
        equip(EquipmentType.MAIN_HAND, itemStack);
    }

    /**
     * Sets the item currently being held in off hand by this entity.
     * @param itemStack The item, using null to remove.
     */
    default void setItemInOffHand(@Nullable ItemStack itemStack){
        equip(EquipmentType.OFF_HAND, itemStack);
    }

    /**
     * Clears the entity of all armor and held items
     */
    default void clearEquipments(){
        for (EquipmentType type : EquipmentType.values()) {
            equip(type, null);
        }
    }
}
