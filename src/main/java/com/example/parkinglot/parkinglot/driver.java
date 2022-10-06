package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;

public class driver {
    public static void main(String[] args) {
        ParkingLot pl= new ParkingLot();
        Vehicle v1= new Vehicle("1", VehicleType.BIKE);
        Vehicle v2= new Vehicle("2", VehicleType.BIKE);
        Vehicle v3= new Vehicle("3", VehicleType.BIKE);
        Vehicle v4= new Vehicle("1", VehicleType.CAR);
        Vehicle v5= new Vehicle("2", VehicleType.CAR);
        Vehicle v6= new Vehicle("3", VehicleType.CAR);

    }
}
