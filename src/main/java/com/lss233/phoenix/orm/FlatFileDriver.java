package com.lss233.phoenix.orm;

import com.lss233.phoenix.Phoenix;

import java.io.File;

/**
 *
 */
public class FlatFileDriver implements ORMDriver {
    private File dbFolder = new File(Phoenix.getServer().getPhoenixDataDir(), "db");

    @Override
    public String getName() {
        return "FlatFile";
    }

    @Override
    public void connect() throws ORMException {
        if(!dbFolder.exists() && !dbFolder.mkdirs())
                throw new ORMException("Failed to create database directory.");
    }
}
