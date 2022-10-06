package com.example.parkinglot.parkinglot;


import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.parkingStrategy.DefaultParkingStrategyImpl;

import java.util.List;

public class bikeParkingSpotManagerImpl extends ParkingSpotManager {

    public bikeParkingSpotManagerImpl(List<Spot> spots) {
        super(spots);
        ps = new DefaultParkingStrategyImpl(this);

    }

    @Override
    public Spot getFreeSpot(VehicleType vt) throws ParkingSpaceFullException {

        return ps.getSpot(vt);
    }


}
