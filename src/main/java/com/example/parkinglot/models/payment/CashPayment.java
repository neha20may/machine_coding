package com.example.parkinglot.models.payment;

public class CashPayment extends Payment{
    public boolean initiateTransaction(){
        return  false;
    }
}
