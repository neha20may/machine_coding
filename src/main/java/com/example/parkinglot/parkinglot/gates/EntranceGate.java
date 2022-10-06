package com.example.parkinglot.parkinglot.gates;

import com.example.parkinglot.parkinglot.Spot;
import com.example.parkinglot.parkinglot.Ticket;
import com.example.parkinglot.parkinglot.Vehicle;

import java.util.Date;

public class EntranceGate extends Gate{

    public EntranceGate(Coordinate cd) {
        super(cd);
    }


    public Ticket generateTicket(Vehicle vehicle, Spot spot) {
        try{
//            Spot spot= pm.getFreeSpot(vehicle.getVehicletype());
//            pm.parkVehicle(vehicle, spot);

            long currenTime= new Date().getTime();
            Ticket ticket= new Ticket();
            ticket.setEntranceTime(currenTime);
            ticket.setVehicle(vehicle);
            ticket.setSpot(spot);
            return ticket;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void pay(Ticket ticket) {
        //not allowed
        return ;
    }


}
