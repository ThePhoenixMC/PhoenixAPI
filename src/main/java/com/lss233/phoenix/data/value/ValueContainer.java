package com.lss233.phoenix.data.value;

import com.lss233.phoenix.data.key.Key;

import java.util.*;

/**
 *
 */
public interface ValueContainer {
    /**
     * Gets the value of this object.
     * @param key The key
     * @param <E> The type of the value
     * @return The value, if exists
     */
    <E> Optional<E> get(Key<E> key);

    /**
     * Gets all available keys of this object.
     * @return The keys
     */
    Set<Key<?>> getKeys();

    /**
     * Get all available values of this object.
     * @return The values.
     */
    Set<?> getValues();

    /**
     * Gets the value of this object.
     * If the value is not exists, return the default value.
     * @param key The key
     * @param def The default value.
     * @param <E> The type of the value.
     * @return The value, if exists, or the default value, if not exists.
     */
    default <E> E getOrElse(Key<E> key, E def){
        if(get(key).isPresent())
            return get(key).get();
        else
            return def;
    }

    /**
     * Gets the value of this object.
     * If thie value is not exists, return null.
     * @param key The key
     * @param <E> The type of the value
     * @return The value, if exists. Or null, if not exists.
     */
    default <E> E getOrNull(Key<E> key){
        if(get(key).isPresent())
            return get(key).get();
        else
            return null;
    }

    /**
     * Checks if the provided key is supported.
     * @param key The key to check.
     * @return True if supports.
     */
    default boolean supports(Key<?> key){
        return getKeys().contains(key);
    }

    /**
     * Sets a value of this object.
     * @param key The key
     * @param value The value
     * @param <E> The type of this value
     */
    <E> void set(Key<E> key, E value);
}
