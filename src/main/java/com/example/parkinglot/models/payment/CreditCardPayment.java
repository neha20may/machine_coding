package com.example.parkinglot.models.payment;

public class CreditCardPayment extends Payment{
    String nameOnCard;
    public boolean initiateTransaction(){
        return  false;
    }
}
