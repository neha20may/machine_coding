package com.example.parkinglot.models.spot;

import com.example.parkinglot.constants.ParkingSpotType;
import com.example.parkinglot.models.vehicle.Vehicle;

public abstract class ParkingSpot {
    public String getNumber() {
        return number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    String number;
    abstract public boolean isFree();
    Vehicle vehicle;

    public ParkingSpotType getType() {
        return type;
    }

    final public ParkingSpotType type;

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }
    public boolean assignVehicle(Vehicle vehicle){
        return false;
    }
    public boolean removeVehicle(){
        return  false;
    }

}
