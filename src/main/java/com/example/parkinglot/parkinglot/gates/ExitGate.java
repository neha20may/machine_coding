package com.example.parkinglot.parkinglot.gates;

import com.example.parkinglot.parkinglot.Spot;
import com.example.parkinglot.parkinglot.Ticket;
import com.example.parkinglot.parkinglot.Vehicle;

public class ExitGate extends Gate{
    public ExitGate(Coordinate cd) {
        super(cd);
        payment= new Payment();
    }

    @Override
    public Ticket generateTicket(Vehicle vehicle, Spot spot) {
        //not allowed here
        return null;
    }

    Payment payment;
    public void pay(Ticket ticket){
        payment.pay(ticket);
    }
}
