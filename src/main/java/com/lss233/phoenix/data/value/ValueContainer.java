package com.lss233.phoenix.data.value;

import com.lss233.phoenix.data.DataKey;

import java.util.*;

/**
 *
 */
public interface ValueContainer {
    default Optional<?> get(DataKey key){
        return Optional.of(getData().get(key));
    }
    default Set<DataKey> getKeys(){
        return getData().keySet();
    }
    default Object get(DataKey key, Object def){
        return get(key).isPresent()? get(key).get() : def;
    }
    default boolean supports(DataKey key){
        return getData().containsKey(key);
    }
    default Collection<?> getValues(){
        return getData().values();
    }
    Map<DataKey, Object> getData();
}
