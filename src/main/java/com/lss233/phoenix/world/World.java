package com.lss233.phoenix.world;

import com.lss233.phoenix.block.Block;
import com.lss233.phoenix.entity.living.Player;
import com.lss233.phoenix.utils.Identifiable;

import java.util.List;
import java.util.UUID;

/**
 * A loaded Minecraft world.
 */
public interface World extends Identifiable, EntityUniverse{

    /**
     * Gets the name of this world.
     * @return The name of this world.
     */
    String getName();

    /**
     * Gets an list of Players currently in this world.
     * @return An collection of players currently in this world.
     */
    List<Player> getPlayers();

    /**
     * Gets the UUID of this world.
     * @return The UUID of this world.
     */
    UUID getUniqueId();

    /**
     * Gets the properties of the world.
     * @return The properties of this world.
     */
    WorldProperties getProperties();

    boolean setBlock(Block block,boolean force);

    default boolean equals(World other){
        return this.equals((Identifiable)other);
    }

    /**
     * Gets the Location of the spawn point.
     * @return The location
     */
    Location getSpawnLocation();

    /**
     * Gets the sea level for this world.
     * @return The sea level.
     */
    int	getSeaLevel();

    /**
     * Saves world to disk
     */
    void save();

    /**
     * Gets chunk at the given chunk coordinate position.
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @return
     */
    Chunk getChunk(int x, int z);

    /**
     * Gets the Chunk at the given Location
     * @param location Location of the chunk
     * @return Chunk at the given location
     */
    Chunk getChunk(Location location);

    /**
     * Gets the Chunk that contains the given Block
     * @param block Location of the chunk
     * @return Chunk at the given location
     */
    default Chunk getChunk(Block block){
        return getChunk(block.getBlockLocation());
    }

    /**
     * Loads the Chunk at the specified coordinates
     * @param x X-coordinate of the chunk
     * @param z Z-coordinate of the chunk
     * @param shouldGenerate Whether or not to generate a chunk if it doesn't already exist.
     * @return true if the chunk has loaded successfully, otherwise false.
     */
    boolean loadChunk(int x, int z, boolean shouldGenerate);

    /**
     * Unload the specified
     * @param chunk The chunk
     * @return True if successfully loaded.
     */
    boolean unloadChunk(Chunk chunk);

    /**
     * Creates explosion at given coordinates with given power
     * @param x X coordinate
     * @param y Y coordinate
     * @param z Z coordinate
     * @param power he power of explosion, where 4F is TNT
     */
    void createExplosion​(double x, double y, double z, float power);

    /**
     * Returns a Collection of all actively loaded chunks in this world.
     * @return The loaded chunks
     */
    List<Chunk> getLoadedChunks();
}
