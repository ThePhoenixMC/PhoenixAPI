package com.lss233.phoenix.config;

import java.util.List;

/**
 * Represents a section of a {@link Configuration}
 */
public interface ConfigurationSection {
    /**
     * If the value for the requested key does
     * not exist but a default value has been
     * specified, this will return true.
     * @param key Key to check for existence.
     * @return True if this section contains the requested key,
     *   either via default or being set.
     */
    boolean contains(String key);

    /**
     * Sets the specified key to the given value.
     * <p>
     *     If value is null, the entry will be removed.
     *     Any existing entry will be replaced,
     *     regardless of what the new value is.
     * </p>
     * @param key Key of the object to set.
     * @param value New value to set the key to.
     */
    void set(String key, Object value);

    /**
     * Gets the requested Object by key.
     * @param key Key of the Object to get.
     * @return Requested Object.
     */
    Object get(String key);

    /**
     * Gets the requested Object by key,
     * returning a default value if not found.
     * @param key Key of the Object to get.
     * @param def The default value to return if the key is not found.
     * @return Requested Object.
     */
    Object get(String key, Object def);

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
    String getString(String key);

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
     *     not a String.
     * @return Requested String.
     */
    String getString(String key, String def);

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
    Integer getInteger(String key);

    /**
     * Gets the requested Integer by key, returning a default value if not found.
     * <p>
     * If the Integer does not exist then the specified default value will
     * returned regardless of if a default has been identified in the root
     * {@link Configuration}.
     *
     * @param key Key of the int to get.
     * @param def The default value to return if the key is not found or is
     *     not an Integer.
     * @return Requested Integer.
     */
    Integer getInteger(String key, int def);

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
    Boolean getBoolean(String key);

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
     *     not a Boolean.
     * @return Requested Boolean.
     */
    Boolean getBoolean(String key, boolean def);

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
    Double getDouble(String key);

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
     *     not a Double.
     * @return Requested Double.
     */
    Double getDouble(String key, Double def);

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
    Long getLong(String key);

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
     *     not a Long.
     * @return Requested Long.
     */
    Long getLong(String key, Long def);

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
    List getList(String key);

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
     *     not a List.
     * @return Requested List.
     */
    List getList(String key, List def);

    /**
     * Gets the requested ConfigurationSection by key, returning a null if not
     * found.
     * @param key Key of the ConfigurationSection to get.
     * @return Requested section.
     */
    ConfigurationSection getSection(String key);

}
