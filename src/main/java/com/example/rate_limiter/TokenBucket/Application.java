package com.example.rate_limiter.TokenBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(3);
        int i = 0;
        while (i<Integer.MAX_VALUE) {
            executors.execute(() -> {

                try {
//                    Thread.sleep(1000);
                    userBucketCreator.accessApplication(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executors.shutdown();
    }
}
