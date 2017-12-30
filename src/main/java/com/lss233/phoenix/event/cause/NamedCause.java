package com.lss233.phoenix.event.cause;

/**
 * A pseudo naming schema for "named" Cause objects.
 * Refer to the design of <a href="https://github.com/SpongePowered/SpongeAPI/blob/a4aaeec0007ebd9c3570e41382454e81f875e0a1/src/main/java/org/spongepowered/api/event/cause/NamedCause.java">Sponge</a>.
 */
public class NamedCause {
    public final String name;
    public final Object object;

    public NamedCause(String name, Object obj) {
        this.name = name;
        this.object = obj;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NamedCause other = (NamedCause) obj;
        return this.name.equals(other.name)
                && this.object.equals(other.object);
    }
}
