package com.example.parkinglot.models;

import com.example.parkinglot.constants.ParkingSpotType;
import com.example.parkinglot.models.spot.ParkingSpot;

import java.util.EnumMap;
import java.util.List;

public class ParkingFloorBuilder {
    private String name;
    private ParkingDisplayPanel parkingDisplayPanel;
    private EnumMap<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    private EnumMap<ParkingSpotType, Integer> freeParkingSpots;

    public ParkingFloorBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingFloorBuilder setParkingDisplayPanel(ParkingDisplayPanel parkingDisplayPanel) {
        this.parkingDisplayPanel = parkingDisplayPanel;
        return this;
    }

    public ParkingFloorBuilder setParkingSpots(EnumMap<ParkingSpotType, List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
        return this;
    }

    public ParkingFloorBuilder setFreeParkingSpots() {
        this.freeParkingSpots = freeParkingSpots;
        return this;
    }

    public ParkingFloor createParkingFloor() {
        return new ParkingFloor(name);
    }
}