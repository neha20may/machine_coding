package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(ParkingSpotType type) {
        super(type);
    }

    @Override
    public boolean isFree() {
        return false;
    }
}
