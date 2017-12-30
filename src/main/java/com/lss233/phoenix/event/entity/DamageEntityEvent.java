package com.lss233.phoenix.event.entity;

import com.lss233.phoenix.event.Cancellable;
import com.lss233.phoenix.event.Event;
import com.lss233.phoenix.event.cause.entity.DamageModifier;

/**
 * Represents the base event for when an Entity is being "attacked".
 */
public interface DamageEntityEvent extends Event, Cancellable {

    /**
     * Gets the raw amount of damage caused by the event
     * @return The raw amount of damage caused by the event
     */
    double getDamage();

    /**
     * Gets the amount of damage caused by the event after all damage reduction is applied.
     * @return The amount of damage caused by the event
     */
    double getFinalDamage();

    /**
     * Gets the damage for the provide {@link com.lss233.phoenix.event.entity.DamageEntityEvent}.
     * @param damageModifier The DamageModifier
     * @return The raw amount of damage caused by the event
     */
    double getDamage(DamageModifier damageModifier);

}
