package com.lss233.phoenix.event.cause;

import java.util.*;

/**
 * A cause represents the reason or initiator of an event.
 * Refer to the design of <a href="https://github.com/SpongePowered/SpongeAPI/blob/a4aaeec0007ebd9c3570e41382454e81f875e0a1/src/main/java/org/spongepowered/api/event/cause/Cause.java">Sponge</a>.
 */
@SuppressWarnings("unchecked")
public final class Cause {
    private String[] names;
    private Object[] cause;

    public Cause(NamedCause[] causes) {
        this.names = new String[causes.length];
        this.cause = new Object[causes.length];
        for (int i = 0; i < causes.length; i++) {
            this.names[i] = causes[i].name;
            this.cause[i] = causes[i].object;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public <T> Optional get(String name, Class<T> target) {
        for (int i = 0; i < names.length; i++)
            if (this.names[i].equalsIgnoreCase(name))
                if (target.isInstance(this.cause[i]))
                    return Optional.of(this.cause[i]);
        return Optional.empty();
    }

    public <T> Optional<T> first(Class<T> target) {
        for (Object aCause : cause) {
            if (target.isInstance(aCause))
                return Optional.of((T) aCause);
        }
        return Optional.empty();
    }

    public <T> Optional last(Class<T> target) {
        for (int i = cause.length - 1; i >= 0; i--) {
            if (target.isInstance(this.cause[i]))
                return Optional.of((T) this.cause[i]);

        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cause) {
            Cause cause = ((Cause) object);
            return Arrays.equals(this.cause, cause.cause);
        }
        return false;
    }

    @Override
    public String toString() {
        String causeString = "Cause[";
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < this.cause.length; i++) {
            joiner.add("{Name=" + this.names[i] + ", Object={" + this.cause[i].toString() + "}}");
        }
        return causeString + joiner.toString() + "]";
    }


    public static final class Builder {
        private List<NamedCause> causes = new ArrayList<>();
        private Set<String> usedName = new HashSet<>();

        public Cause build() {
            return new Cause(causes.toArray(new NamedCause[causes.size()]));

        }

        public Builder add(String name, Object obj) {
            if (usedName.contains(name))
                throw new IllegalArgumentException("The entry already exist.");
            causes.add(new NamedCause(name, obj));
            return this;
        }

        public Builder add(NamedCause cause) {
            if (usedName.contains(cause.name))
                throw new IllegalArgumentException("The entry already exist.");
            causes.add(cause);
            return this;
        }

        public Builder reset() {
            causes.clear();
            usedName.clear();
            return this;
        }

    }
}
