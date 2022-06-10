package com.example.parkinglot.models.vehicle;

import com.example.parkinglot.constants.VehicleType;
import com.example.parkinglot.models.ParkingTicket;
import org.springframework.context.annotation.Bean;

public class Vehicle {
    private String licenseNumber;
    private VehicleType type;
    ParkingTicket ticket;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public Vehicle(String licenseNumber, VehicleType vehicle) {
        this.licenseNumber = licenseNumber;
        this.type =vehicle;
    }

    public static Vehicle createVehicle(String licenseNumber, VehicleType vehicle) {
        return new Vehicle(licenseNumber, vehicle);
    }

    public void assignTicket(ParkingTicket parkingTicket){
        this.ticket=parkingTicket;
    }
}
