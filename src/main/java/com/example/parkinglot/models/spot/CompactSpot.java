package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;

public class CompactSpot extends ParkingSpot {
    @Override
    public boolean isFree() {
        return false;
    }

    public CompactSpot(ParkingSpotType type) {
        super(type);
    }
}
