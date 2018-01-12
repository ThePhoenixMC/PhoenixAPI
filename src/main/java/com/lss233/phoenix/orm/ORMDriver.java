package com.lss233.phoenix.orm;
/**
 *
 */
public interface ORMDriver {
    String getName();
    void connect() throws ORMException;

}
