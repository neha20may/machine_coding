package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.parkingStrategy.ParkingStrategy;

import java.util.List;

public abstract class ParkingSpotManager {
    public List<Spot> getSpots() {
        return spots;
    }

    List<Spot> spots;
    ParkingStrategy ps;

    public ParkingSpotManager(List<Spot> spots) {
        this.spots = spots;
    }

    public abstract Spot getFreeSpot(VehicleType vt) throws ParkingSpaceFullException;

    public Spot parkVehicle(Vehicle vehicle) throws ParkingSpaceFullException {
        Spot spot= getFreeSpot(vehicle.getVehicletype());
        spot.setVehicle(vehicle);
        spot.isFree = false;
        ps.removeSpot(spot);
        return  spot;
    }


    public void removeVehicle(Vehicle vehicle, Spot spot) {
        spot.setVehicle(null);
        spot.isFree = true;
        ps.addSpot(spot);
    }
}
