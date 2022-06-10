package com.example.parkinglot.models;

import com.example.parkinglot.constants.ParkingTicketStatus;

import java.util.Date;

public class ParkingTicket {
    String ticketNumer;
    Date issueAt;
    Date payedAt;

    public ParkingTicket(String s, Date date, double v, ParkingTicketStatus active) {
    }

    public ParkingTicket(String ticketNumer,
                         Date issueAt, Date payedAt,
                         double parkingCharge, ParkingTicketStatus parkingTicketStatus) {
        this.ticketNumer = ticketNumer;
        this.issueAt = issueAt;
        this.payedAt = payedAt;
        this.parkingCharge = parkingCharge;
        this.parkingTicketStatus = parkingTicketStatus;
    }

    public String getTicketNumer() {
        return ticketNumer;
    }

    double parkingCharge;
    ParkingTicketStatus parkingTicketStatus;
}
