/*
 * MIT License
 *
 * Copyright (c) 2018 PhoenixMC and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lss233.phoenix.world;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lss233.phoenix.config.json.deserializer.ChunkDeserializer;
import com.lss233.phoenix.config.json.serializer.ChunkSerializer;

@JsonDeserialize(using = ChunkDeserializer.class)
@JsonSerialize(using = ChunkSerializer.class)
public interface Chunk extends EntityUniverse {

    /**
     * Gets the world containing this chunk
     * @return The world.
     */
    World getWorld();

    /**
     *
     * Gets the X-coordinate of this chunk
     * @return The X-coordinate of this chunk
     */
    int getX();

    /**
     * Gets the Z-coordinate of this chunk
     * @return The Z-coordinate of this chunk
     */
    int getZ();

    /**
     * Checks if the chunk is loaded.
     * @return True if loaded.
     */
    boolean isLoaded();

    /**
     * Loads the chunk.
     * @param generate  Whether or not to generate a chunk if it doesn't already exist.
     * @return True if the chunk has loaded successfully, otherwise false.
     */
    boolean load(boolean generate);

    /**
     * Unloads this chunk, if possible.
     * @return Whether or not the chunk unloaded.
     */
    boolean	unload();
}
