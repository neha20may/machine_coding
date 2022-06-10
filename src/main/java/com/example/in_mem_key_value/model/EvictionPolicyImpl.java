package com.example.in_mem_key_value.model;

import java.util.LinkedList;

public class EvictionPolicyImpl extends EvictionPolicy {
    public EvictionPolicyImpl() {
        super(new LinkedList<>()); //TODO: thats how you pass here the external data structure? or some pattern to use to change the underlying ds?
    }

    @Override
    public String evict(String key) {
        String keyToEvict=queue.removeFirst();
        return keyToEvict;
    }

    @Override
    public void keyAccess(String key) {
        queue.remove(key); //TODO: O(n), reduce it to O(1) //Leetcode doesnt take this list implementaion for lasrge two test cases!
        queue.add(key);
    }

    @Override
    public void remove(String key) {
        queue.remove(key);
    }
}
