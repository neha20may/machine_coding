package com.example.parkinglot.models.account;

import com.example.parkinglot.constants.AccountStatus;

public abstract class Account {
    String username;
    String password;
    AccountStatus accountStatus;
    Person person;
    public abstract boolean resetPassword();

}
