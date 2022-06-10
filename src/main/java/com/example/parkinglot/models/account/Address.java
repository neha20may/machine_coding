package com.example.parkinglot.models.account;

public class Address {
    String city;
    String street;
    String state;

    public Address(String city, String street, String state, String country) {
        this.city = city;
        this.street = street;
        this.state = state;
        this.country = country;
    }

    String country;
}
