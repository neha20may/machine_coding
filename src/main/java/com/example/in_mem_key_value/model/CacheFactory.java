package com.example.in_mem_key_value.model;


//make it singleton?
//TODO : revise Factory and singleton pattern
//Can we keep local variable in factory that are needed for new calll of object?
//can we make factory singleton?
//arent both creational pattern?
public class CacheFactory {
    int capacity;
    private static CacheFactory instance;
    private Cache cache;

    private CacheFactory(int capacity) {
        cache = new Cache(new EvictionPolicyImpl(), new StorageImpl(capacity));
    }

    public static CacheFactory getInstance(int capacity) {
        if (instance == null) {
            instance = new CacheFactory(capacity);
        }
        return instance;
    }

    public Cache getCache() {
        return cache;
    }
}
