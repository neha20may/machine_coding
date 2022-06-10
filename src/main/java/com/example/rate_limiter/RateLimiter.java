package com.example.rate_limiter;

public interface RateLimiter {
    boolean grantAccess() throws InterruptedException;
}
