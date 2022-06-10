package com.example.in_mem_key_value.exception;

public class StorageFullException extends Exception {
    public StorageFullException() {
        super();
    }

    public StorageFullException(String message) {
        super(message);
    }

    public StorageFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageFullException(Throwable cause) {
        super(cause);
    }
}
