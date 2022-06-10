package com.example.parkinglot.controller;

import com.example.parkinglot.constants.ParkingSpotType;
import com.example.parkinglot.exceptions.ParkingFullException;
import com.example.parkinglot.models.ParkingLot;
import com.example.parkinglot.models.ParkingTicket;
import com.example.parkinglot.models.vehicle.Vehicle;
import com.example.parkinglot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Response;

import javax.xml.ws.http.HTTPException;
////Check this out to confirm your design choiecs.
////https://github.com/pulkitent/parking-lot-lld-oop-ood

@RestController
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping("/")
    public String helloWorld() {
        String message = "Hi , Welcome to Parking Lot";
        return message;
    }

    @PostMapping("/park")
    public String parkVehicle(@RequestBody Vehicle vehicle) {
        try {
            ParkingTicket t = parkingLotService.parkVehicle(vehicle);
            return new String("Here is your ticket " + t.getTicketNumer());
        } catch (ParkingFullException exception) {
            System.err.println(exception.getMessage());
            throw new HTTPException(HttpStatus.NOT_FOUND.value());
        }
    }

    @GetMapping("/display")
    public String getDisplay(@RequestParam(name = "floor") String floor,
                             @RequestParam(name = "type") ParkingSpotType type) {
        String message=parkingLotService.displayBoard(floor, type);
        return message;

    }

}
