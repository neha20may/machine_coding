package com.example.lift_management.service;

import com.example.lift_management.model.HallButton;
import com.example.lift_management.model.Passenger;

public class HallCallService {
    HallButton button;

    public void handleHallCall() {
        //tun on the button
        button.turnOn();

    }
}
