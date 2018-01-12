package com.lss233.phoenix.config.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lss233.phoenix.Phoenix;
import com.lss233.phoenix.config.FileConfiguration;
import com.lss233.phoenix.config.MemoryConfiguration;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class JsonConfiguration extends MemoryConfiguration implements FileConfiguration{
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private File file;
    private Map<String, Object> map;

    public JsonConfiguration(Map<String, Object> map) {
        super(map);
    }

    public JsonConfiguration(File file) throws IOException {
        reload();
    }

    public static JsonConfiguration load(File file) throws IOException {
        JsonConfiguration configuration = new JsonConfiguration(file);
        configuration.reload();
        return configuration;
    }

    @Override
    public void save(File file) throws IOException, IllegalArgumentException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(file))){
            gson.toJson(map, writer);
        } catch(IOException ex){
            Phoenix.getLogger("Phoenix").warn("Cannot write to " + file);
            throw ex;
        }
    }

    @Override
    public void reload() throws IOException {
        try(Reader reader = new InputStreamReader(new FileInputStream(file))){
            HashMap<String, Object> hashMap = new HashMap<>();
            this.map = gson.fromJson(reader, hashMap.getClass());
        } catch (Exception ex){
            Phoenix.getLogger("Phoenix").warn("Cannot load from " + file);
            throw ex;
        }

    }
}
