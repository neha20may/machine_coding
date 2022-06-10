package com.example.rate_limiter.TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class


UserBucketCreator {
    Map<Integer, TokenBucket> bucket;

    public UserBucketCreator(int id) {
        bucket = new HashMap<>();
        bucket.put(id, new TokenBucket(3, 1));
    }

    void accessApplication(int id) throws InterruptedException {
        if(bucket.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application at "+ System.currentTimeMillis()/1000);
        }else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time at"+ System.currentTimeMillis()/1000);
            Thread.sleep(1000);
        }
    }
}
