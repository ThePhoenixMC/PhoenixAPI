package com.lss233.phoenix.world;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lss233.phoenix.config.json.deserializer.LocationDeserializer;
import com.lss233.phoenix.config.json.serializer.LocationSerializer;
import com.lss233.phoenix.math.Vector;

import java.util.Objects;

/**
 * A Minecraft location.
 */
@JsonDeserialize(using = LocationDeserializer.class)
@JsonSerialize(using = LocationSerializer.class)
public class Location {
    private World world;
    private double x, y, z;
    private float yaw, pitch;

    public Location(World world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0;
        this.pitch = 0;
    }

    public Location(World world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
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

    public int getBlockX() {
        return (int) Math.round(x);
    }

    public int getBlockY() {
        return (int) Math.round(y);
    }

    public int getBlockZ() {
        return (int) Math.round(z);
    }

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public Vector getVector(){
        return new Vector(x,y,z);
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        int hash = 15;
        hash = 37 * hash + (int) Double.doubleToLongBits(this.getX());
        hash = 37 * hash + (int) Double.doubleToLongBits(this.getY());
        hash = 37 * hash + (int) Double.doubleToLongBits(this.getZ());
        hash = 37 * hash + Float.floatToIntBits(this.getYaw());
        hash = 37 * hash + Float.floatToIntBits(this.getPitch());
        return hash;
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
