package com.example.zoom_car.carrental.src.repository;

import com.example.zoom_car.carrental.src.model.account.Account;
import com.example.zoom_car.carrental.src.exceptions.AccountDoesNotExistsException;

public interface AccountRepository {
    Account createAccount(Account account);

    void resetPassword(String userId, String password) throws AccountDoesNotExistsException;
}
