package com.example.parkinglot.models;

import com.example.parkinglot.constants.ParkingSpotType;
import com.example.parkinglot.models.spot.*;
import com.example.parkinglot.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.example.parkinglot.constants.ParkingSpotType.Handicapped;

public class ParkingFloor {
    String name;
//    List<ParkingSpot> parkingSpots; //ideally a databse

    public ParkingFloor(String name) {
        this.name = name;
    }

    ParkingDisplayPanel parkingDisplayPanel;
    EnumMap<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    EnumMap<ParkingSpotType, Integer> freeParkingSpots;//?

//    private ParkingFloor(String name, ParkingDisplayPanel parkingDisplayPanel, EnumMap<ParkingSpotType, List<ParkingSpot>> parkingSpots, EnumMap<ParkingSpotType, Integer> freeParkingSpots) {
//        this.name = name;
//        this.parkingDisplayPanel = parkingDisplayPanel;
//        this.parkingSpots = parkingSpots;
//        this.freeParkingSpots = freeParkingSpots;
//    }


    public ParkingFloor(String name, ParkingDisplayPanel parkingDisplayPanel, EnumMap<ParkingSpotType, List<ParkingSpot>> parkingSpots, EnumMap<ParkingSpotType, Integer> freeParkingSpots) {
        this.name = name;
        this.parkingDisplayPanel = parkingDisplayPanel;
        this.parkingSpots = parkingSpots;
        this.freeParkingSpots = freeParkingSpots;
    }

    void updateParkingDisplay(ParkingSpot parkingSpot) {
        if (this.parkingDisplayPanel.getNumber(parkingSpot) == parkingSpot.getNumber()) {
            List<ParkingSpot> spots = parkingSpots.get(parkingSpot.getType());
            for (ParkingSpot s : spots) {
                if (s.isFree()) {
                    parkingDisplayPanel.setSpot(parkingSpot);
                }
            }
        }
    }

    void addParkingSpot(ParkingSpot parkingSpot) {

//        parkingSpotsList.put(parkingSpot.getType(),parkingSpot);
        if(parkingSpots==null){
            parkingSpots= new EnumMap<ParkingSpotType, List<ParkingSpot>>(ParkingSpotType.class);
        }
        if (parkingSpots.get(parkingSpot.type) == null)
            parkingSpots.put(parkingSpot.type, new ArrayList<ParkingSpot>());

        switch (parkingSpot.getType()) {

            case Handicapped:
                parkingSpots.get(Handicapped).add(parkingSpot);
                break;
            case MotorBike:
                parkingSpots.get(ParkingSpotType.MotorBike).add(parkingSpot);
                break;
            case Compact:
                parkingSpots.get(ParkingSpotType.Compact).add(parkingSpot);
                break;
            case Large:
                parkingSpots.get(ParkingSpotType.Large).add(parkingSpot);
                break;
            case Electric:
                parkingSpots.get(ParkingSpotType.Large).add(parkingSpot);
                break;
        }
    }

    void assignVehicleToSpot(Vehicle vehicle, ParkingSpot parkingSpot) {
        parkingSpot.assignVehicle(vehicle);
        updateParkingDisplay(parkingSpot);
    }

    void freeSpot(ParkingSpot parkingSpot) {
        parkingSpot.removeVehicle();
        freeParkingSpots.put(parkingSpot.getType(),freeParkingSpots.get(parkingSpot.getType())+1);

    }

    public boolean isFull() {
        for(Map.Entry<ParkingSpotType, Integer> entry: freeParkingSpots.entrySet()){
            int s= (int) entry.getValue();
            if(s!=0)
                return false;
        }
        return true;
    }
}
