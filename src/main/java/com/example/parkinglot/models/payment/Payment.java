package com.example.parkinglot.models.payment;

import com.example.parkinglot.constants.ParkingTicketStatus;

import java.util.Date;

abstract class Payment {
    Date createDate;
    double amount;
    ParkingTicketStatus status;
    public abstract boolean initiateTransaction();
}
