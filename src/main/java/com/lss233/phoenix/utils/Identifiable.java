package com.lss233.phoenix.utils;

import java.util.UUID;

/**
 * An identifiable object has a UUID that can be retrieved.
 */
public interface Identifiable {
    /**
     * Gets the unique ID for this object.
     * @return The {@link UUID}
     */
    UUID getUniqueId();
}
