package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.exceptions.InvalidVehicleIdException;
import com.example.zoom_car.carrental.src.exceptions.ReservationNotFoundException;
import com.example.zoom_car.carrental.src.exceptions.VehicleBookedException;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;
import com.example.zoom_car.carrental.src.model.vehicle.HireableVehicle;
import com.example.zoom_car.carrental.src.model.vehicle.VehicleLocation;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {
    VehicleReservation scanToReserve(String qrCode, String userId) throws InvalidVehicleIdException, VehicleBookedException;

    VehicleReservation remoteReserve(VehicleReservation vehicleReservation);

    VehicleReservation cancel(String reservationId);

    HireableVehicle pickupVehicle(VehicleReservation vehicleReservation);

    void returnVehicle(String reservationId, VehicleLocation vehicleLocation) throws ReservationNotFoundException;

    List<HireableVehicle> getHiredVehicles(String userId);

    List<HireableVehicle> getHiredVehicles(String userId, LocalDateTime startDate,
                                           LocalDateTime endDate);
}
