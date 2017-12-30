package com.lss233.phoenix.command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * .
 */
public class ArgumentsMap{
    private Map<String,Object> argsMap = new HashMap<>();

    void set(String key,Object value){
        argsMap.put(key,value);
    }
    void set(String key,Object[] value){
        argsMap.put(key, Arrays.asList(value));
    }

    public int getInt(String key){
        return (int) argsMap.get(key);
    }
    public int[] getInts(String key){
        return ((List<Integer>)argsMap.get(key)).stream().mapToInt(i->i).toArray();
    }
    public double getDouble(String key){ return (double) argsMap.get(key); }
    public double[] getDoubles(String key){
        return ((List<Double>)argsMap.get(key)).stream().mapToDouble(i->i).toArray();
    }
    public boolean getBoolean(String key){
        return (Boolean) argsMap.get(key);
    }
    public String getString(String key){
        return String.valueOf(argsMap.get(key));
    }
    public Object get(String key){
        return argsMap.get(key);
    }
}
