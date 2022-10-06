package com.example.parkinglot.parkinglot.parkingStrategy;

import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.ParkingSpotManager;
import com.example.parkinglot.parkinglot.Spot;
import com.example.parkinglot.parkinglot.enums.VehicleType;

import java.util.List;

public class DefaultParkingStrategyImpl extends ParkingStrategy {


    ParkingSpotManager pm;
    List<Spot> freeSpots;

    public DefaultParkingStrategyImpl(ParkingSpotManager pm) {
        super(pm);
        for (Spot spot : pm.getSpots()){
            if(spot.isFree())
                freeSpots.add(spot);
        }
    }

    @Override
    public Spot getSpot(VehicleType vt) throws ParkingSpaceFullException {
        if(freeSpots.size()>0)
        {
            Spot spt= freeSpots.get(0);
            return spt;
        }

        throw new ParkingSpaceFullException("space full for parking");
    }

    @Override
    public void removeSpot(Spot spot) {
        freeSpots.remove(spot);
    }

    @Override
    public void addSpot(Spot spot) {
        //do nothing list contains the spots and spot has been changed
        //if i maintain the separate ds then I need that ;
        freeSpots.add(spot);
    }

}
