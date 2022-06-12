package com.example.parkinglot.solution1.parkinglot.src.model.account;

import com.example.parkinglot.solution1.parkinglot.src.model.account.common.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private String phone;
    private String email;
    private Address address;
    private PersonalInfo personalInfo;
}
