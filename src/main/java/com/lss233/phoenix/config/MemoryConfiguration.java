package com.lss233.phoenix.config;

import java.util.*;

/**
 *
 */
public class MemoryConfiguration implements ConfigurationSection{
    private Map<String, Object> map;
    public MemoryConfiguration(Map<String, Object> map) {
        this.map = map;
    }

    protected Map<String, Object> getMap() {
        return map;
    }

    protected void setMap(Map<String, Object> map) {
        this.map = map;
    }

    protected MemoryConfiguration() {
    }

    /**
     * If the value for the requested key does
     * not exist but a default value has been
     * specified, this will return true.
     *
     * @param key Key to check for existence.
     * @return True if this section contains the requested key,
     * either via default or being set.
     */
    @Override
    public boolean contains(String key) {
        return map.containsKey(key);
    }

    /**
     * Sets the specified key to the given value.
     * <p>
     * If value is null, the entry will be removed.
     * Any existing entry will be replaced,
     * regardless of what the new value is.
     * </p>
     *
     * @param key   Key of the object to set.
     * @param value New value to set the key to.
     */
    @Override
    public void set(String key, Object value) {
        map.put(key, value);
    }

    /**
     * Sets the specified key to the given section.
     *
     * @param key     The key of the section to set.
     * @param section New section to set the key to.
     */
    @Override
    public void setSection(String key, ConfigurationSection section) {
        this.map.put(key, ((MemoryConfiguration)section).map);
    }

    /**
     * Gets the requested Object by key.
     *
     * @param key Key of the Object to get.
     * @return Requested Object.
     */
    @Override
    public Object get(String key) {
        return map.get(key);
    }

    /**
     * Gets the requested Object by key,
     * returning a default value if not found.
     *
     * @param key Key of the Object to get.
     * @param def The default value to return if the key is not found.
     * @return Requested Object.
     */
    @Override
    public Object get(String key, Object def) {
        return map.getOrDefault(key, def);
    }

    /**
     * Gets the requested String by key.
     * <p>
     * If the String does not exist but a default value has been specified,
     * this will return the default value. If the String does not exist and no
     * default value was specified, this will return null.
     *
     * @param key Key of the String to get.
     * @return Requested String.
     */
    @Override
    public String getString(String key) {
        return String.valueOf(map.get(key));
    }

    /**
     * Gets the requested String by key, returning a default value if not
     * found.
     * <p>
     * If the String does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the String to get.
     * @param def The default value to return if the key is not found or is
     *            not a String.
     * @return Requested String.
     */
    @Override
    public String getString(String key, String def) {
        return String.valueOf(map.getOrDefault(key, def));
    }

    /**
     * Gets the requested Integer by key.
     * <p>
     * If the Integer does not exist but a default value has been specified,
     * this will return the default value. If the int does not exist and no
     * default value was specified, this will return null.
     *
     * @param key Key of the Integer to get.
     * @return Requested Integer.
     */
    @Override
    public Integer getInteger(String key) {
        return Integer.valueOf(getString(key));
    }

    /**
     * Gets the requested Integer by key, returning a default value if not found.
     * <p>
     * If the Integer does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the int to get.
     * @param def The default value to return if the key is not found or is
     *            not an Integer.
     * @return Requested Integer.
     */
    @Override
    public Integer getInteger(String key, int def) {
        return contains(key) ? getInteger(key) : def;
    }

    /**
     * Gets the requested Boolean by key.
     * <p>
     * If the Boolean does not exist but a default value has been specified,
     * this will return the default value. If the Boolean does not exist and
     * no default value was specified, this will return false.
     *
     * @param key Key of the Boolean to get.
     * @return Requested Boolean.
     */
    @Override
    public Boolean getBoolean(String key) {
        return Boolean.valueOf(getString(key));
    }

    /**
     * Gets the requested Boolean by key, returning a default value if not
     * found.
     * <p>
     * If the Boolean does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the Boolean to get.
     * @param def The default value to return if the key is not found or is
     *            not a Boolean.
     * @return Requested Boolean.
     */
    @Override
    public Boolean getBoolean(String key, boolean def) {
        return contains(key) ? getBoolean(key) : def;
    }

    /**
     * Gets the requested Double by key.
     * <p>
     * If the Double does not exist but a default value has been specified,
     * this will return the default value. If the Double does not exist and no
     * default value was specified, this will return null.
     *
     * @param key Key of the Double to get.
     * @return Requested Double.
     */
    @Override
    public Double getDouble(String key) {
        return Double.valueOf(getString(key));
    }

    /**
     * Gets the requested Double by key, returning a default value if not
     * found.
     * <p>
     * If the Double does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the Double to get.
     * @param def The default value to return if the key is not found or is
     *            not a Double.
     * @return Requested Double.
     */
    @Override
    public Double getDouble(String key, Double def) {
        return contains(key) ? getDouble(key) : def;
    }

    /**
     * Gets the requested Long by key.
     * <p>
     * If the Long does not exist but a default value has been specified, this
     * will return the default value. If the Long does not exist and no
     * default value was specified, this will return null.
     *
     * @param key Key of the Long to get.
     * @return Requested Long.
     */
    @Override
    public Long getLong(String key) {
        return Long.valueOf(getString(key));
    }

    /**
     * Gets the requested Long by key, returning a default value if not
     * found.
     * <p>
     * If the Long does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the Long to get.
     * @param def The default value to return if the key is not found or is
     *            not a Long.
     * @return Requested Long.
     */
    @Override
    public Long getLong(String key, Long def) {
        return contains(key) ? getLong(key) : def;
    }

    /**
     * Gets the requested List by key.
     * <p>
     * If the List does not exist but a default value has been specified, this
     * will return the default value. If the List does not exist and no
     * default value was specified, this will return null.
     *
     * @param key Key of the List to get.
     * @return Requested List.
     */
    @Override
    public List getList(String key) {
        return Collections.singletonList(get(key));
    }

    /**
     * Gets the requested List by key, returning a default value if not
     * found.
     * <p>
     * If the List does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the List to get.
     * @param def The default value to return if the key is not found or is
     *            not a List.
     * @return Requested List.
     */
    @Override
    public List getList(String key, List def) {
        return contains(key) ? getList(key) : def;
    }

    /**
     * Gets the key set of this section.
     *
     * @return The key set.
     */
    @Override
    public Set<String> getKeys() {
        return map.keySet();
    }

    /**
     * Gets the requested ConfigurationSection by key, returning a null if not
     * found.
     *
     * @param key Key of the ConfigurationSection to get.
     * @return Requested section.
     */
    @Override
    public ConfigurationSection getSection(String key) {
        return new MemoryConfiguration((Map<String, Object>) get(key));
    }

    /**
     * Add a new empty section.
     *
     * @param key The key of the section to add.
     * @return The new section.
     */
    @Override
    public ConfigurationSection addSection(String key) {
        ConfigurationSection section = empty();
        setSection(key, section);
        return section;
    }

    /**
     * Gets an empty memory configuration section.
     * @return An empty memory configuration section.
     */
    public static MemoryConfiguration empty(){
        return new MemoryConfiguration(new HashMap<>());
    }
}
