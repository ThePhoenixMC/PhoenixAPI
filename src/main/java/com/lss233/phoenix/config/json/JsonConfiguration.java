package com.lss233.phoenix.config.json;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper mapper = new ObjectMapper();
    private File source;
    private HashMap<String, Object> map = new HashMap<>();

    /**
     * Creates a JsonConfiguration by a map.
     * @param map The map.
     */
    public JsonConfiguration(Map<String, Object> map) {
        super(map);
    }

    /**
     * Creates a JsonConfiguration by a file.
     * @param source The file.
     * @throws IOException Failed to load config from the file.
     */
    private JsonConfiguration(File source) throws IOException {
        this.source = source;
        reload();
    }

    /**
     * Loads config from disk.
     * @param source The source of the file.
     * @return Config instance.
     * @throws IOException Failed to load file.
     */
    public static JsonConfiguration load(File source) throws IOException {
        return new JsonConfiguration(source);
    }

    /**
     * Creates a new empty {@link JsonConfiguration} instance.
     * @return A new empty {@link JsonConfiguration} instance.
     */
    public static JsonConfiguration empty(){
        return new JsonConfiguration(new HashMap<>());
    }


    /**
     * Saves current configs to a specify file.
     * @param source The target file.
     * @throws IOException Failed to save file.
     */
    @Override
    public void save(File source) throws IOException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(source))){
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(writer, getMap());
        } catch(IOException ex){
            Phoenix.getLogger("Phoenix").warn("Cannot write to " + source);
            throw ex;
        }
    }

    /**
     * Reload configuration from file.
     * @throws IOException Failed to load file.
     */
    @Override
    public void reload() throws IOException {
        try(Reader reader = new InputStreamReader(new FileInputStream(source))){
            Map result = mapper.readValue(reader, this.map.getClass());
            setMap(result == null ? this.map : result);
        } catch (Exception ex){
            Phoenix.getLogger("Phoenix").warn("Cannot load from " + source);
            throw ex;
        }

    }

    /**
     * Saves current configs to file.
     * @throws IOException Failed to save file.
     */
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
