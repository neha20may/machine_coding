package com.example.parkinglot.parkinglot.parkingStrategy;

import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.ParkingSpotManager;
import com.example.parkinglot.parkinglot.Spot;
import com.example.parkinglot.parkinglot.enums.VehicleType;

public abstract class ParkingStrategy {
    ParkingSpotManager pm;

    public ParkingStrategy(ParkingSpotManager pm) {
        this.pm = pm;
    }

    public abstract Spot getSpot(VehicleType vt) throws ParkingSpaceFullException;

    public abstract void addSpot(Spot spot);

    public abstract void removeSpot(Spot spot) ;
}
