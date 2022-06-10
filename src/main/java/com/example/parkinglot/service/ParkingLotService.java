package com.example.parkinglot.service;

import com.example.parkinglot.constants.ParkingSpotType;
import com.example.parkinglot.exceptions.ParkingFullException;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingTicket;
import com.example.parkinglot.models.vehicle.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ParkingLotService {
    private ParkingLot parkinglot;
    public ParkingLotService(){
        parkinglot=ParkingLot.getInstance();
    }
    public ParkingTicket parkVehicle(Vehicle vehicle) throws ParkingFullException {
        return parkinglot.getNewParkingTicket(vehicle);
    }
    public String displayBoard(String floor, ParkingSpotType spotType)  {
        HashMap<String, ParkingFloor> floors=parkinglot.getParkingFloors();
        ParkingFloor pf=floors.get(floor);
//        pf.displayBoard()
        return "";
    }
}
