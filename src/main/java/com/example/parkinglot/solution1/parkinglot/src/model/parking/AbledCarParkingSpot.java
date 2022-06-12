package com.example.parkinglot.solution1.parkinglot.src.model.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbledCarParkingSpot extends ParkingSpot {
    public AbledCarParkingSpot(String id) {
        super(id, ParkingSpotType.ABLED);
    }
}
