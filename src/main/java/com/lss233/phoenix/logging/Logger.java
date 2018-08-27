package com.lss233.phoenix.logging;

/**
 * .
 */
public interface Logger {
    void info(Object msg);
    void warn(Object msg);
    void debug(Object msg);
    void severe(Object msg);
}
