package com.example.lift_management.api;

import com.example.lift_management.service.HallCallService;

//api for press button
public class HallButtonController extends ButtonController{
    HallCallService hallCallService;
    public void HallCall() {
        hallCallService.handleHallCall();
    }
}
