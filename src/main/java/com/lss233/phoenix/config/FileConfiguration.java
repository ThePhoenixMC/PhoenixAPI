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

    /**
     * Saves current configs to file.
     * @throws IOException Failed to save file.
     */
    void save() throws IOException;

    /**
     * Saves current configs to a specify file.
     * @param source The target file.
     * @throws IOException Failed to save file.
     */
    void save(File source) throws IOException;

    /**
     * Sets the source file of the config.
     * @param source The source file.
     */
    void setSource(File source);

    /**
     * Gets the source file of the config
     * @return The source file of the config.
     */
    File getSource();


}
