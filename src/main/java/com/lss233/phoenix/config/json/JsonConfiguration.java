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
    private File source;
    private Map<String, Object> map;

    public JsonConfiguration(Map<String, Object> map) {
        super(map);
    }

    private JsonConfiguration(File source) throws IOException {
        this.source = source;
        reload();
    }

    public static JsonConfiguration load(File source) throws IOException {
        JsonConfiguration configuration = new JsonConfiguration(source);
        return configuration;
    }

    public static JsonConfiguration empty(){
        return new JsonConfiguration(new HashMap<>());
    }


    @Override
    public void save(File source) throws IOException, IllegalArgumentException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(source))){
            gson.toJson(map, writer);
        } catch(IOException ex){
            Phoenix.getLogger("Phoenix").warn("Cannot write to " + source);
            throw ex;
        }
    }

    @Override
    public void reload() throws IOException {
        try(Reader reader = new InputStreamReader(new FileInputStream(source))){
            HashMap<String, Object> hashMap = new HashMap<>();
            this.map = gson.fromJson(reader, hashMap.getClass());
        } catch (Exception ex){
            Phoenix.getLogger("Phoenix").warn("Cannot load from " + source);
            throw ex;
        }

    }

    @Override
    public void save() throws IOException {
        save(this.source);
    }

    @Override
    public void setSource(File source) {
        this.source = source;
    }

    @Override
    public File getSource() {
        return this.source;
    }
}
