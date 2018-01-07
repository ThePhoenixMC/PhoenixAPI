package com.lss233.phoenix.orm;

import java.util.HashMap;
import java.util.Map;

/**
 *  Phoenix driver manager.
 */
public class ORMManager {
    private Map<String,ORMDriver> drivers = new HashMap<>();
    /**
     * Register a new driver.
     * @param driver The driver
     */
    public void registerDriver(ORMDriver driver){
        drivers.put(driver.getName(), driver);
    }
}
