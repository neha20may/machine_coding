package com.example.zoom_car.carrental.src.model.account;

import com.example.zoom_car.carrental.src.model.common.Address;
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
