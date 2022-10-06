package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;
import com.example.parkinglot.parkinglot.exceptions.ParkingSpaceFullException;
import com.example.parkinglot.parkinglot.gates.Coordinate;
import com.example.parkinglot.parkinglot.gates.EntranceGate;
import com.example.parkinglot.parkinglot.gates.ExitGate;
import com.example.parkinglot.parkinglot.gates.Gate;

public class ParkingLot {
    ParkingSpotManager pm1;
    ParkingSpotManager pm2;
    ParkingSpotManagerFactory pmFactory;
    Gate gate1;
    Gate gate2;

    public ParkingLot() {

        this.pmFactory = new ParkingSpotManagerFactory();
        pm1= pmFactory.getParkingSpotManager(VehicleType.BIKE);
        pm2= pmFactory.getParkingSpotManager(VehicleType.CAR);
        gate1= new EntranceGate(new Coordinate(0,0));
        gate2= new ExitGate(new Coordinate(10,10));

    }

    Ticket park(Vehicle vehicle) {
        if (vehicle.getVehicletype() == VehicleType.BIKE) {
            try {
                Spot spot= pm1.parkVehicle(vehicle);
                Ticket ticket= gate1.generateTicket(vehicle, spot);
                return ticket;
            } catch (ParkingSpaceFullException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                Spot spot= pm2.parkVehicle(vehicle);
                Ticket ticket= gate1.generateTicket(vehicle, spot);
                return ticket;
            } catch (ParkingSpaceFullException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void unpark(Vehicle vehicle, Ticket ticket){
        if (vehicle.getVehicletype() == VehicleType.BIKE) {
            pm1.removeVehicle(vehicle);
            gate2.pay(ticket);
        }else{

        }
    }
}
