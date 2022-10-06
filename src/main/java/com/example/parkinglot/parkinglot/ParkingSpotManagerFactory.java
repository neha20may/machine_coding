package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.gates.Coordinate;
import com.example.parkinglot.parkinglot.gates.EntranceGate;
import com.example.parkinglot.parkinglot.gates.Gate;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerFactory {
    ParkingSpotManager pm;
    ParkingSpotManager getParkingSpotManager(VehicleType vt){
        if(vt== VehicleType.BIKE)
        {
            List<Spot> bikeSpots = new ArrayList<>();
            bikeSpots.add(new Spot(1, 1, new Coordinate(1,1)));
            bikeSpots.add(new Spot(1, 2, new Coordinate(1,2)));
            return new bikeParkingSpotManagerImpl(bikeSpots);
        }
        else
        {
            List<Spot> carSpots = new ArrayList<>();
            carSpots.add(new Spot(2, 1, new Coordinate(2,1)));
            carSpots.add(new Spot(2, 2, new Coordinate(2,2)));
            carSpots.add(new Spot(2, 3, new Coordinate(2,3)));

            Coordinate cd= new Coordinate(0, 0);
            Gate entranceGate= new EntranceGate(cd);
            return  new CarParkingSpotManagerImpl(carSpots, entranceGate);
        }
    }
}
