package com.lss233.phoenix.math;

import com.lss233.phoenix.world.Location;
import com.lss233.phoenix.world.World;

/**
 * Represents a vector.
 */
public class Vector implements Cloneable {
    protected double x;
    protected double y;
    protected double z;

    /**
     * Construct the vector with all axises as 0.
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    /**
     * Construct the vector with provided integer axises.
     *
     * @param x X axis
     * @param y Y axis
     * @param z Z axis
     */
    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Construct the vector with provided double axises.
     *
     * @param x X axis
     * @param y Y axis
     * @param z Z axis
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Construct the vector with provided float axises.
     *
     * @param x X axis
     * @param y Y axis
     * @param z Z axis
     */
    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Adds a vector to this one
     *
     * @param vector Another vector
     * @return The vector
     */
    public Vector add(Vector vector) {
        x += vector.x;
        y += vector.y;
        z += vector.z;
        return this;
    }

    /**
     * Subtracts a vector from this one.
     *
     * @param vector Another
     * @return The vector
     */
    public Vector subtract(Vector vector) {
        x -= vector.x;
        y -= vector.y;
        z -= vector.z;
        return this;
    }

    /**
     * Multiplies the vector by another.
     *
     * @param vector Another vector
     * @return The vector
     */
    public Vector multiply(Vector vector) {
        x *= vector.x;
        y *= vector.y;
        z *= vector.z;
        return this;
    }

    /**
     * Divides the vector by another.
     *
     * @param vector Another vector
     * @return The vector
     */
    public Vector divide(Vector vector) {
        x /= vector.x;
        y /= vector.y;
        z /= vector.z;
        return this;
    }

    /**
     * Copies another vector
     *
     * @param vector Another vector
     * @return The vector
     */
    public Vector copy(Vector vector) {
        x = vector.x;
        y = vector.y;
        z = vector.z;
        return this;
    }

    /**
     * Gets the magnitude of the vector.
     *
     * @return The magnitude
     */
    public double length() {
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    /**
     * Get the distance between this vector and another.
     *
     * @param vector Another vector
     * @return The distance
     */
    public double distance(Vector vector) {
        return Math.sqrt(Math.pow(x - vector.x,2) + Math.pow(y - vector.y,2) + Math.pow(z - vector.z,2));
    }

    /**
     * Gets the angle between this vector and another in radians.
     *
     * @param vector Another vector
     * @return Angle in radians
     */
    public float angle(Vector vector) {
        double dot = dot(vector) / (length() * vector.length());

        return (float) Math.acos(dot);
    }

    /**
     * Sets this vector to the midpoint between this vector and another.
     *
     * @param vecotor Another vector
     * @return The vector
     */
    public Vector midpoint(Vector vecotor) {
        x = (x + vecotor.x) / 2;
        y = (y + vecotor.y) / 2;
        z = (z + vecotor.z) / 2;
        return this;
    }

    /**
     * Gets a new midpoint vector between this vector and another.
     *
     * @param other The other vector
     * @return a new midpoint vector
     */
    public Vector getMidpoint(Vector other) {
        double x = (this.x + other.x) / 2;
        double y = (this.y + other.y) / 2;
        double z = (this.z + other.z) / 2;
        return new Vector(x, y, z);
    }

    /**
     * Performs scalar multiplication, multiplying all axises with a
     * scalar.
     *
     * @param m The factor
     * @return The vector
     */
    public Vector multiply(int m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * Performs scalar multiplication, multiplying all axises with a
     * scalar.
     *
     * @param m The factor
     * @return The vector
     */
    public Vector multiply(double m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * Performs scalar multiplication, multiplying all axises with a
     * scalar.
     *
     * @param m The factor
     * @return The vector
     */
    public Vector multiply(float m) {
        x *= m;
        y *= m;
        z *= m;
        return this;
    }

    /**
     * Calculates the dot product of this vector with another. The dot product
     * is defined as x1*x2+y1*y2+z1*z2. The returned value is a scalar.
     *
     * @param other The other vector
     * @return dot product
     */
    public double dot(Vector other) {
        return x * other.x + y * other.y + z * other.z;
    }

    /**
     * Calculates the cross product of this vector with another. The cross
     * product is defined as:
     * <ul>
     * <li>x = y1 * z2 - y2 * z1
     * <li>y = z1 * x2 - z2 * x1
     * <li>z = x1 * y2 - x2 * y1
     * </ul>
     *
     * @param o The other vector
     * @return The vector
     */
    public Vector crossProduct(Vector o) {
        double newX = y * o.z - o.y * z;
        double newY = z * o.x - o.z * x;
        double newZ = x * o.y - o.x * y;

        x = newX;
        y = newY;
        z = newZ;
        return this;
    }

    /**
     * Converts this vector to a unit vector (a vector with length of 1).
     *
     * @return The vector
     */
    public Vector normalize() {
        double length = length();

        x /= length;
        y /= length;
        z /= length;

        return this;
    }

    /**
     * Zero this vector's axises.
     *
     * @return The vector
     */
    public Vector zero() {
        x = 0;
        y = 0;
        z = 0;
        return this;
    }

    /**
     * Returns whether this vector is in an axis-aligned bounding box.
     * <p>
     * The minimum and maximum vectors given must be truly the minimum and
     * maximum X, Y and Z axises.
     *
     * @param min Minimum vector
     * @param max Maximum vector
     * @return whether this vector is in the AABB
     */
    public boolean isInAABB(Vector min, Vector max) {
        return x >= min.x && x <= max.x && y >= min.y && y <= max.y && z >= min.z && z <= max.z;
    }

    /**
     * Returns whether this vector is within a sphere.
     *
     * @param origin Sphere origin.
     * @param radius Sphere radius
     * @return whether this vector is in the sphere
     */
    public boolean isInSphere(Vector origin, double radius) {
        return (Math.pow(origin.x - x, 2) + Math.pow(origin.y - y, 2) + Math.pow(origin.z - z, 2)) <= Math.pow(radius, 2);
    }

    /**
     * Gets the X axis.
     *
     * @return The X axis.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the Y axis.
     *
     * @return The Y axis.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the Z axis.
     *
     * @return The Z axis.
     */
    public double getZ() {
        return z;
    }


    /**
     * Gets the floored value of the X axis.
     *
     * @return Floored x.
     */
    public int getFloorX(){
        return (int) Math.floor(x);
    }

    /**
     * Gets the floored value of the Y axis.
     *
     * @return Floored y.
     */
    public int getFloorY(){
        return (int)Math.floor(y);
    }

    /**
     * Gets the floored value of the Z axis.
     *
     * @return Floored z.
     */
    public int getFloorZ(){
        return (int)Math.floor(z);
    }


    /**
     * Set the X axis.
     *
     * @param x The new X axis.
     * @return This vector.
     */
    public Vector setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * Set the X axis.
     *
     * @param x The new X axis.
     * @return This vector.
     */
    public Vector setX(double x) {
        this.x = x;
        return this;
    }

    /**
     * Set the X axis.
     *
     * @param x The new X axis.
     * @return This vector.
     */
    public Vector setX(float x) {
        this.x = x;
        return this;
    }

    /**
     * Set the Y axis.
     *
     * @param y The new Y axis.
     * @return This vector.
     */
    public Vector setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Y axis.
     *
     * @param y The new Y axis.
     * @return This vector.
     */
    public Vector setY(double y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Y axis.
     *
     * @param y The new Y axis.
     * @return This vector.
     */
    public Vector setY(float y) {
        this.y = y;
        return this;
    }

    /**
     * Set the Z axis.
     *
     * @param z The new Z axis.
     * @return This vector.
     */
    public Vector setZ(int z) {
        this.z = z;
        return this;
    }

    /**
     * Set the Z axis.
     *
     * @param z The new Z axis.
     * @return This vector.
     */
    public Vector setZ(double z) {
        this.z = z;
        return this;
    }

    /**
     * Set the Z axis.
     *
     * @param z The new Z axis.
     * @return This vector.
     */
    public Vector setZ(float z) {
        this.z = z;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Improve later
        if (obj instanceof Vector) {
            Vector other = (Vector) obj;

            return other.z == z && other.y == y && other.x == x;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // https://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
        int hash = 14;
        hash = 37 * hash + (int)Double.doubleToLongBits(this.getX());
        hash = 37 * hash + (int)Double.doubleToLongBits(this.getY());
        hash = 37 * hash + (int)Double.doubleToLongBits(this.getZ());
        return hash;
    }

    /**
     * Get a new vector.
     *
     * @return vector
     */
    @Override
    public Vector clone() {
        try {
            return (Vector) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e);
        }
    }
    /**
     * Gets a Location version of this vector with zero yaw and pitch.
     *
     * @param world The world to link the location to.
     * @return The location
     */
    public Location toLocation(World world) {
        return new Location(world, x, y, z);
    }

    /**
     * Gets a Location version of this vector.
     *
     * @param world The world to link the location to.
     * @param yaw The desired yaw.
     * @param pitch The desired pitch.
     * @return The location
     */
    public Location toLocation(World world, float yaw, float pitch) {
        return new Location(world, x, y, z, yaw, pitch);
    }
}