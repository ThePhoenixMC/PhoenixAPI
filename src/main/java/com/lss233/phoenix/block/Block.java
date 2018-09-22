package com.lss233.phoenix.block;

import com.google.common.base.Preconditions;
import com.lss233.phoenix.world.Location;

import java.util.Optional;
import java.util.UUID;


/**
 * .
 */
public class Block {

    private Builder builder;
    private UUID creator;
    private BlockState blockState;
    private Location blockLocation;

    private Block(Builder builder) {
        this.builder = builder;
        this.blockState = Preconditions.checkNotNull(builder.blockState);
        this.blockLocation = Preconditions.checkNotNull(builder.location);
        this.creator = builder.creator;
    }

    public Optional<UUID> getCreator() {
        return Optional.ofNullable(creator);
    }

    public BlockState getBlockState() {
        return blockState;
    }

    public Location getBlockLocation() {
        return blockLocation;
    }

    public boolean restore(boolean force) {
        return blockLocation.getWorld().setBlock(this, force);
    }

    public Block withLocation(Location location) {
        return builder.location(location).build();
    }

    public Block withCreator(UUID creator) {
        return builder.creator(creator).build();
    }

    public Builder getBuilder() {
        return this.builder;
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
