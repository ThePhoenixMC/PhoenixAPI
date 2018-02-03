package com.lss233.phoenix.block;

import com.lss233.phoenix.world.Location;

import java.util.Optional;
import java.util.UUID;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * .
 */
public class Block {

    private UUID creator;
    private BlockState blockState;
    private Location blockLocation;

    public Block(Builder builder) {
        this.blockState = checkNotNull(builder.blockState);
        this.blockLocation = checkNotNull(builder.location);
        this.creator = builder.creator;
    }

    public Optional<UUID> getCreator() {
        return Optional.ofNullable( creator);
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public Location getBlockLocation() {
        return blockLocation;
    }

    public boolean restore(boolean force){
        //TODO
        return true;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID creator;
        private BlockState blockState;
        private Location location;

        public Builder creator(UUID creator) {
            this.creator = creator;
            return this;
        }

        public Builder state(BlockState state) {
            this.blockState = state;
            return this;
        }

        public Builder location(Location location) {
            this.location = location;
            return this;
        }

        public Block build() {
            return new Block(this);
        }
    }

}
