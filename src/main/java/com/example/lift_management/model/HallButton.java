package com.example.lift_management.model;

import com.example.lift_management.api.HallButtonController;

public class HallButton {
    HallButtonController controller;
    public void press() {
        controller.HallCall();
    }

    public void turnOn() {
    }
}
