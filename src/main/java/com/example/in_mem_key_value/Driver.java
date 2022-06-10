package com.example.in_mem_key_value;

import com.example.in_mem_key_value.model.Cache;
import com.example.in_mem_key_value.model.CacheFactory;

public class Driver {
    public static void main(String[] args) {
        Cache cache = CacheFactory.getInstance(2).getCache(); //TODO: thats how you pass param in factory?
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println("key1: " + cache.get("key1"));
        System.out.println("key2: "+cache.get("key2"));
        cache.put("key4", "value4");
    }
}
