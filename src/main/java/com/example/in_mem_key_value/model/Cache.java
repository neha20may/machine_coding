package com.example.in_mem_key_value.model;

import com.example.in_mem_key_value.exception.StorageFullException;

public class Cache {
    EvictionPolicy evictionPolicy; //context?
    Storage storage; //

    public Cache(EvictionPolicy evictionPolicy, Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }


    public void put(String key, String value) {
        if (storage.isEmpty()) {
            try {
                storage.put(key, value);
                evictionPolicy.keyAccess(key);
                System.out.println("put " + key + " " + value);
            } catch (StorageFullException e) {
                e.printStackTrace();
            }

        } else {
            String keyToEvict = evictionPolicy.evict(key);
            storage.remove(keyToEvict);
            System.out.println("Evicted: " + keyToEvict);
            try {
                storage.put(key, value);
                evictionPolicy.keyAccess(key);
                System.out.println("put " + key + " " + value);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public String get(String key) {
        try {
            evictionPolicy.keyAccess(key);
            return storage.get(key);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    public void remove(String key) {
        storage.remove(key);
        evictionPolicy.remove(key);
    }
}
