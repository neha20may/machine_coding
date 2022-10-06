package com.example.parkinglot.parkinglot.gates;

import com.example.parkinglot.parkinglot.Ticket;

import java.util.Date;

public class Payment {
    public void pay(Ticket ticket){
        System.out.println("for vehicle "+ticket.getVehicle().getVehicletype() + " spot "+ticket.getSpot().getSpotId()+ "for time ");
        long curtime= new Date().getTime();
        System.out.println(curtime-ticket.getEntranceTime());
        System.out.println("; paying 100 rs");
    }
}
