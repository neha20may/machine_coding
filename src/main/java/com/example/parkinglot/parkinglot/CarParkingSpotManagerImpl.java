package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.gates.Gate;
import com.example.parkinglot.parkinglot.parkingStrategy.NearestParkingStrategy;

import java.util.List;

public class CarParkingSpotManagerImpl extends ParkingSpotManager {

    public CarParkingSpotManagerImpl(List<Spot> spots, Gate gate) {
        super(spots);
        ps= new NearestParkingStrategy(this, gate);
    }

    @Override
    public Spot getFreeSpot(VehicleType vt) throws ParkingSpaceFullException {
        return ps.getSpot(vt);
    }


}
