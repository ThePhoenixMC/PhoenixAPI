package com.lss233.phoenix.utils;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public interface IOable {
    /**
     * Saves this configuration file to the specified location.
     * <p>
     * If the file does not exist, it will be created. If already exists, it
     * will be overwritten. If it cannot be overwritten or created, an
     * exception will be thrown.
     * </p>
     *
     * @param file File to save to.
     * @throws IOException Thrown when the given file cannot be written to for
     *     any reason.
     * @throws IllegalArgumentException Thrown when file is null.
     */
    void save(File file) throws IOException, IllegalArgumentException;
}
