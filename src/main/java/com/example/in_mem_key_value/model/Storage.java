package com.example.in_mem_key_value.model;

import com.example.in_mem_key_value.exception.KeyNotFoundException;
import com.example.in_mem_key_value.exception.StorageFullException;

public interface Storage {
    void put(String key, String value) throws StorageFullException;
    String get(String key) throws KeyNotFoundException;
    void remove(String key);
    boolean isEmpty();
}
