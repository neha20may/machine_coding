package com.example.parkinglot.models;

import com.example.parkinglot.models.spot.*;

public class ParkingDisplayPanel {
    //show available parking spots for each spot type.
    // This class will be responsible for displaying the latest availability of free parking spots to the customers.
    String id;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeSpot; //TODO: many subclasses getting created. Use of pattern here!
    private MotorBikeSpot motorBikeSpot;
    private ElectricSpot electricSpot;

    public String getId() {
        return id;
    }

    public HandicappedSpot getHandicappedFreeSpot() {
        return handicappedFreeSpot;
    }

    public CompactSpot getCompactFreeSpot() {
        return compactFreeSpot;
    }

    public LargeSpot getLargeSpot() {
        return largeSpot;
    }

    public MotorBikeSpot getMotorBikeSpot() {
        return motorBikeSpot;
    }

    public ElectricSpot getElectricSpot() {
        return electricSpot;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setSpot(ParkingSpot parkingSpot){
        switch(parkingSpot.getType()){
            case Handicapped: setHandicappedFreeSpot((HandicappedSpot) parkingSpot);
            case MotorBike: setMotorBikeSpot((MotorBikeSpot) parkingSpot);
            case Electric: setElectricSpot((ElectricSpot) parkingSpot);
            case Compact:setCompactFreeSpot((CompactSpot)parkingSpot);
            case Large: setLargeSpot((LargeSpot) parkingSpot);
        }
    }
    public void setHandicappedFreeSpot(HandicappedSpot handicappedFreeSpot) {
        this.handicappedFreeSpot = handicappedFreeSpot;
    }

    public void setCompactFreeSpot(CompactSpot compactFreeSpot) {
        this.compactFreeSpot = compactFreeSpot;
    }

    public void setLargeSpot(LargeSpot largeSpot) {
        this.largeSpot = largeSpot;
    }

    public void setMotorBikeSpot(MotorBikeSpot motorBikeSpot) {
        this.motorBikeSpot = motorBikeSpot;
    }

    public void setElectricSpot(ElectricSpot electricSpot) {
        this.electricSpot = electricSpot;
    }

    public String getNumber(ParkingSpot parkingSpot) {
        return parkingSpot.getNumber();
    }

    public void showEmptyNumber() {
        String message = "";
        if (handicappedFreeSpot.isFree()) {
            message += " gree handicapp=" + handicappedFreeSpot.getNumber();
        }
        if (motorBikeSpot.isFree()) {
            message += "free motorbike" + motorBikeSpot.getNumber();

        }
        if (largeSpot.isFree()) {
            message += " free large " + largeSpot.getNumber();
        }
        if (compactFreeSpot.isFree()) {
            message += " compact " + compactFreeSpot.getNumber();
        }
        if (electricSpot.isFree()) {
            message += "free electrci" + electricSpot.getNumber();
        }
        message += System.lineSeparator();
        show(message);

    }

    private void show(String message) {
        System.out.println(message);
    }
}
