package com.example.parkinglot.parkinglot;

import com.example.parkinglot.parkinglot.enums.VehicleType;

public class Vehicle {
    String id;

    public Vehicle(String id, VehicleType vehicletype) {
        this.id = id;
        this.vehicletype = vehicletype;
    }

    VehicleType vehicletype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        this.vehicletype = vehicletype;
    }
}
