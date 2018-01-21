package com.lss233.phoenix.world;

/**
 * Represents the world border of a world.
 */
public interface WorldBorder {

    /**
     * Gets the center of the world border.
     * @return The center of the world border.
     */
    Location getCenter();

    /**
     * Gets the damage done to a player per block per tick when outside the buffer.
     * @return The damage.
     */
    double getDamageAmount();

    /**
     * Gets the distance a player may be outside the world border before taking damage.
     * @return The distance.
     */
    double getDamageThreshold();

    /**
     * Gets the diameter of the world border.
     * @return The diameter.
     */
    double getDiameter();

    /**
     * Gets the distance when a contracting world border will warn a player for whom the world border is distance blocks away.
     * @return The distance, in blocks
     */
    int getWarningDistance();

    /**
     * Sets the time when a contracting world border will warn a player for whom the world border will reach in time seconds.
     * @return The time, in seconds
     */
    int getWarningTime();

    /**
     * Sets the center of the world border.
     * @param location The center location of the world border.
     */
    void setCenter(Location location);

    /**
     * Sets the center of the world border.
     * @param x The x-axis center of the world border
     * @param y The z-axis center of the world border
     */
    void setCenter(double x, double y);

    /**
     * Sets the damage done to a player per block per tick when outside the buffer.
     * @param damageAmount The damage amount
     */
    void setDamageAmount(double damageAmount);

    /**
     * Sets the distance a player may be be outside the world border before taking damage.
     * @param damageThreshold The distance, in blocks.
     */
    void setDamageThreshold(double damageThreshold);

    /**
     * Sets the diameter of the world border.
     * @param diameter The diameter
     */
    void setDiameter(double diameter);

    /**
     * Sets the distance when a contracting world border will warn a player for whom the world border is distance blocks away.
     * @param warningDistance The distance, in blocks
     */
    void setWarningDistance(int warningDistance);

    /**
     * Sets the time when a contracting world border will warn a player for whom the world border will reach in time seconds.
     * @param warningTime The time, in seconds
     */
    void setWarningTime(int warningTime);
}
