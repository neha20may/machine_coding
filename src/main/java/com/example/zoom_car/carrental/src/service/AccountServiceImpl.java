package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.exceptions.AccountDoesNotExistsException;
import com.example.zoom_car.carrental.src.model.account.Account;
import com.example.zoom_car.carrental.src.model.account.AccountType;
import com.example.zoom_car.carrental.src.repository.AccountRepository;
import com.example.zoom_car.carrental.src.repository.AccountRepositoryFactory;

public class AccountServiceImpl implements AccountService {

    @Override
    public Account createAccount(Account account, AccountType accountType) {
        AccountRepository accountRepository =
                AccountRepositoryFactory.getAccountRepository(accountType);
        return accountRepository.createAccount(account);
    }

    public void resetPassword(String userId, String password,
                              AccountType accountType) throws AccountDoesNotExistsException {
        AccountRepository accountRepository =
                AccountRepositoryFactory.getAccountRepository(accountType);
        accountRepository.resetPassword(userId, password);
    }
}
