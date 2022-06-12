package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.exceptions.VehicleNotExistsException;
import com.example.zoom_car.carrental.src.model.vehicle.HireableVehicle;

public interface VehicleService {

    HireableVehicle getVehicleById(String id);

    HireableVehicle getVehicleByQrCode(String qrCode);

    HireableVehicle addVehicle(HireableVehicle hireableVehicle);

    void updateQrCode(String vehicleId, String qrCode) throws VehicleNotExistsException;

    void removeVehicle(String vehicleId) throws VehicleNotExistsException;
}
