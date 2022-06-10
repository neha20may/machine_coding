package com.example.in_mem_key_value.model;

import java.util.Deque;

public abstract class EvictionPolicy {
    Deque<String> queue;

    public EvictionPolicy(Deque<String> queue) {
        this.queue = queue;
    }

    abstract String evict(String key);
    abstract void keyAccess(String key);
    abstract  void remove(String key);
}
