package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.gates.Coordinate;

public class Spot {
    int floorId;
    int spotId;

    public Spot(int floorId, int spotId, Coordinate cod) {
        this.floorId = floorId;
        this.spotId = spotId;
        this.cod = cod;
    }

    public Coordinate getCod() {
        return cod;
    }

    public void setCod(Coordinate cod) {
        this.cod = cod;
    }

    Coordinate cod;

    Vehicle vehicle;
    boolean isFree;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }



}
