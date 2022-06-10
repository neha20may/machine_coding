package com.example.parkinglot.exceptions;

public class ParkingFullException extends Exception {
    public ParkingFullException(String message) {
        super(message);
        System.err.println(message);
    }
}
