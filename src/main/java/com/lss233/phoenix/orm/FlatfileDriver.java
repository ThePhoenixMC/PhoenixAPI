package com.lss233.phoenix.orm;

import com.lss233.phoenix.Phoenix;

import java.io.File;

/**
 *
 */
public class FlatfileDriver implements ORMDriver {
    File dbFolder = new File(Phoenix.getServer().getPhoenixDataDir(), "db");

    @Override
    public String getName() {
        return "Flatfile";
    }

    @Override
    public void connect() throws ORMException {
        if(!dbFolder.exists())
            if(!dbFolder.mkdirs())
                throw new ORMException("Failed to create database directory.");
    }
}
