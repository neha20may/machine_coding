package com.example.parkinglot.parkinglot.gates;

import com.example.parkinglot.parkinglot.ParkingSpotManager;
import com.example.parkinglot.parkinglot.Spot;
import com.example.parkinglot.parkinglot.Ticket;
import com.example.parkinglot.parkinglot.Vehicle;

public abstract class Gate {
    public Gate(Coordinate cd) {
        this.cd = cd;
    }

    public Coordinate getCd() {
        return cd;
    }

    public void setCd(Coordinate cd) {
        this.cd = cd;
    }

    Coordinate cd;
    ParkingSpotManager pm;

    public abstract Ticket generateTicket(Vehicle vehicle, Spot spot);
    public abstract void pay(Ticket ticket);


}
