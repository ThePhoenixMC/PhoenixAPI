package com.lss233.phoenix.world;

import java.util.Optional;

/**
 * Represents the properties of a World which are persisted across runtime instances.
 */
public interface WorldProperties {

    /**
     * Gets the difficulty of this world.
     * @return The difficulty
     */
    Difficulty getDifficulty();

    /**
     * Sets the difficulty of this world.
     * @param difficulty The difficulty
     */
    void setDifficulty(Difficulty difficulty);

    /**
     * Gets whether this world is set to hardcore mode.
     * @return Is hardcore
     */
    boolean isHardcore();

    /**
     * Sets whether this world is set to hardcore mode.
     * @param hardcore Is hardcore
     */
    void setHardcore(boolean hardcore);
    /**
     * Gets the seed of this world.
     * @return The seed of this world.
     */
    long getSeed();

    /**
     * Sets the seed of this world.
     * @param seed The new world seed
     */
    void setSeed(long seed);

    /**
     * Gets the number of ticks which have occurred since the world was created.
     * @return The total time in ticks
     */
    long getTotalTime();

    /**
     * Gets the time of day, in ticks. The total number of
     * ticks in a day is 24000, however this value does not
     * reset to zero at the start of each day but rather keeps
     * counting passed 24000.
     * @return The time of day
     */
    long getWorldTime();

    /**
     * Sets the time of day, in ticks. The total number of
     * ticks in a day is 24000, however this value does not
     * reset to zero at the start of each day but rather keeps
     * counting passed 24000.
     * @param time The time of day
     */
    void setWorldTime(long time);

    int getThunderDuration();
    void setThunderDuration(int thunderDuration);
    boolean isThundering();
    void setThundering(boolean thundering);

    int getRainDuration();
    void setRainDuration(int rainDuration);
    boolean isRaining();
    void setRaining(boolean raining);

    /**
     * Gets the specified GameRule value.
     * @param gameRule The name of the GameRule.
     * @return The GameRule value, if it exists.
     */
    Optional<String> getGameRules(String gameRule);

    /**
     * Sets the specified GameRule value. If one with this name does not exist, it will be created.
     * @param key The name of the GameRule.
     * @param value The value to set the GameRule to.
     */
    void setGameRule(String key, String value);

    Location getSpawnLocation();
    void setSpawnLocation(Location spawnLocation);

    WorldBorder getWorldBorderCenter();

}
