package com.lss233.phoenix.world;

import com.lss233.phoenix.entity.Entity;
import com.lss233.phoenix.entity.EntityType;
import com.lss233.phoenix.math.Vector;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * A container of Entity instances.
 */
public interface EntityUniverse {
    /**
     * Create an entity instance at the given position.
     * @param entityType The type
     * @param vector The position
     * @return An entity
     */
    Optional<Entity> createEntity(EntityType entityType, Vector vector);

    /**
     * Return a list of entities contained within {@code distance} blocks
     * of the specified location. This uses a sphere to test distances.
     *
     * @param location The location at the center of the search radius
     * @param distance The search radius
     * @return A list of nearby entities
     */
    List<Entity> getNearbyEntities(Vector location, double distance);

    /**
     * Return a list of entities contained within {@code distance} blocks
     * of the specified location. This uses a sphere to test distances.
     *
     * @param location The location at the center of the search radius
     * @param distance The search radius
     * @return A list of nearby entities
     */
    default List<Entity> getNearbyEntities(Location location, double distance){
        return getNearbyEntities(location.getVector(), distance);
    }

    /**
     * Return a list of entities contained within this world.
     *
     * @return A list of entities
     */
    List<Entity> getEntities();

    /**
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existent.
     *
     * @param uniqueId The unique id
     * @return An entity
     */
    Optional<Entity> getEntity(UUID uniqueId);
}
