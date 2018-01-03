package com.lss233.phoenix.entity;

/**
 *
 */
public interface LivingEntity extends Entity{

    /**
     * get health of entity
     * @return health of entity
     */
    double getHealth();

    /**
     * set health of entity
     * @param health health of entity
     */
    void setHealth(double health);

    /**
     * get max health
     * @return max health
     */
    double getMaxHealth();
}
