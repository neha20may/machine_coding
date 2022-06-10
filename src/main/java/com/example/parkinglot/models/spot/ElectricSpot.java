package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;

public class ElectricSpot extends ParkingSpot {
    @Override
    public boolean isFree() {
        return false;
    }

    public ElectricSpot(ParkingSpotType type) {
        super(type);
    }
}
