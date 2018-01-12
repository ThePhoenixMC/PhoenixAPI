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
    private Map<String, Object> map;

    public JsonConfiguration(Map<String, Object> map) {
        super(map);
    }

    @Override
    public void load(File file) throws IOException {
        try(Reader reader = new InputStreamReader(new FileInputStream(file))){
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap = gson.fromJson(reader, hashMap.getClass());
            map = hashMap;
        } catch (Exception ex){
            Phoenix.getLogger("Phoenix").warn("Cannot load from " + file);
            throw ex;
        }

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
}
