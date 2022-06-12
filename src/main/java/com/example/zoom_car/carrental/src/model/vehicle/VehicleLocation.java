package com.example.zoom_car.carrental.src.model.vehicle;

import com.example.zoom_car.carrental.src.model.common.Address;
import com.example.zoom_car.carrental.src.model.common.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleLocation {
    private String locationId;
    private Address address;
    private Coordinates coordinates;
}
