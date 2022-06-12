package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.exceptions.AccountDoesNotExistsException;
import com.example.zoom_car.carrental.src.model.account.Account;
import com.example.zoom_car.carrental.src.model.account.AccountType;

public interface AccountService {
    Account createAccount(Account account, AccountType accountType);

    void resetPassword(String userId, String password,
                       AccountType accountType) throws AccountDoesNotExistsException;
}
