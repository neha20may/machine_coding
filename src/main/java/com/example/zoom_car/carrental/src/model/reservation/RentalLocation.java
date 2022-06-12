package com.example.zoom_car.carrental.src.model.reservation;

import com.example.zoom_car.carrental.src.model.common.Address;
import com.example.zoom_car.carrental.src.model.common.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalLocation {
    private String id;
    private Address address;
    private Coordinates coordinates;
}
