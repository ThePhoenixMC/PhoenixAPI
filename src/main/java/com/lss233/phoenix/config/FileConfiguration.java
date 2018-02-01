package com.lss233.phoenix.config;

import com.lss233.phoenix.utils.IOable;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public interface FileConfiguration extends Configuration, IOable{
    /**
     * Reload configuration from file.
     * @throws IOException Failed to load file.
     */
    void reload() throws IOException;

    void save() throws IOException;

    void setSource(File source);

    File getSource();


}
