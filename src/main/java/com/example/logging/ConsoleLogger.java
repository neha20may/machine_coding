package com.example.logging;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("CONSOLE MESSAGE : "+ message);
    }
}
