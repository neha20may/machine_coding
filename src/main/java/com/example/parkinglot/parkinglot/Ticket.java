package com.example.parkinglot.parkinglot;

public class Ticket {
    long entranceTime;
    Vehicle vehicle;
    Spot spot;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public long getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(long entranceTime) {
        this.entranceTime = entranceTime;
    }
}
