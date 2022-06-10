package com.example.parkinglot.models.payment;

public class DebitCardPayment extends Payment{
    double cashTendered;
    public boolean initiateTransaction(){
        return  false;
    }
}
