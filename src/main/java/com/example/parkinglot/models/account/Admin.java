package com.example.parkinglot.models.account;

import com.example.parkinglot.models.ParkingDisplayPanel;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.panel.EntrancePanel;
import com.example.parkinglot.models.panel.ExitPanel;
import com.example.parkinglot.models.portal.CustomerInfoPortal;
import com.example.parkinglot.models.spot.ParkingSpot;

public class Admin extends Account {
    //TODO: design pattern
    public boolean addParkingFloor(ParkingFloor parkingFloor) {
        return false;
    }

    public boolean addParkingSlot(ParkingSpot parkingSpot, String floorName) {
        return false;
    }

    public boolean addParkingDisplay(ParkingDisplayPanel parkingDisplay, String floorName){
        return false;
    }
    public boolean addCustomerInfoPanel(CustomerInfoPortal customerInfoPortal, String floor){
        return false;
    }
    public boolean addEntry(EntrancePanel entrancePanel){
        return  false;
    }
    public boolean addExit(ExitPanel exitPanel){
        return  false;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
