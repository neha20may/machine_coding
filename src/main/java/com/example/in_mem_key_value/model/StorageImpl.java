package com.example.in_mem_key_value.model;

import com.example.in_mem_key_value.exception.KeyNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class StorageImpl implements Storage {
    int capacity = 0;
    Map<String, String> map;

    public StorageImpl(int capacity) {
        this.capacity = capacity;
        map= new HashMap<>(capacity);
    }

    @Override
    public void put(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String get(String key) throws KeyNotFoundException {
        return map.get(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public boolean isEmpty() {
        if(map.size()<capacity)
            return true;
        else
            return false;
    }

}
