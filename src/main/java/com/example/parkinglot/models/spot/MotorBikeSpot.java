package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;

public class MotorBikeSpot extends ParkingSpot {
    @Override
    public boolean isFree() {
        return false;
    }

    public MotorBikeSpot(ParkingSpotType type) {
        super(type);
    }
}
