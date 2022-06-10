package com.example.parkinglot.models.account;

import com.example.parkinglot.models.account.Account;

public class ParkingAttendant extends Account {
  public boolean processTicket(){
      return false;
  }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
