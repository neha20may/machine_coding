package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;

public class LargeSpot extends ParkingSpot {
    @Override
    public boolean isFree() {
        return false;
    }

    public LargeSpot(ParkingSpotType type) {
        super(type);
    }
}
