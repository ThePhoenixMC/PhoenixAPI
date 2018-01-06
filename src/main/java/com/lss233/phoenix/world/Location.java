package com.lss233.phoenix.world;

import java.util.Objects;

/**
 * A Minecraft location.
 */
public class Location {
    private World world;
    private double x, y, z;

    public Location(World world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    int getBlockX() {
        return (int) Math.round(x);
    }

    int getBlockY() {
        return (int) Math.round(y);
    }

    int getBlockZ() {
        return (int) Math.round(z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location other = (Location) obj;
            return Objects.equals(this, other);
        }
        return false;
    }
}
