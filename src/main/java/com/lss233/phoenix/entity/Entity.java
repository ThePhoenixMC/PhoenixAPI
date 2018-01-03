package com.lss233.phoenix.entity;

import com.lss233.phoenix.Location;

/**
 *
 */
public interface Entity {
    Location getLocation();

    /**
     * teleport to position
     * @param location position
     * @return return true if teleport is successful
     */
    boolean teleport(Location location);

    /**
     * teleport to entity
     * @param entity entity
     * @return return true if teleport is successful
     */
    boolean teleport(Entity entity);


}
