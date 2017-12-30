package com.lss233.phoenix.command;

/**
 *
 */
public class Argument {
    private final String key;
    private final Type type;
    private final Object value;

    public Argument(String key, Type type, Object value) {
        this.key = key;
        this.type = type;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Type getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public enum Type{
        PATH,
        REQUIRED,
        OPETION
    }
}
