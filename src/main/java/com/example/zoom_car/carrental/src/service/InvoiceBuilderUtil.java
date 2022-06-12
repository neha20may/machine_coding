package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.model.account.User;
import com.example.zoom_car.carrental.src.model.reservation.Invoice;
import com.example.zoom_car.carrental.src.model.reservation.VehicleFixedCosts;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;
import com.example.zoom_car.carrental.src.model.vehicle.HireableVehicle;
import com.example.zoom_car.carrental.src.repository.UserRepository;
import com.example.zoom_car.carrental.src.repository.VehicleRepository;

import java.util.UUID;

public class InvoiceBuilderUtil {
    public static Invoice buildCancelledInvoice(VehicleReservation vehicleReservation) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(UUID.randomUUID().toString());
        invoice.setReservationId(vehicleReservation.getReservationId());
        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUsrId());
        invoice.setUserId(user.getEmail());
        HireableVehicle hireableVehicle = VehicleRepository.vehicleMap
                .get(vehicleReservation.getAccocatedVehicleId());
        double fixedCost = VehicleFixedCosts
                .vehicleFixedCost.get(hireableVehicle.getVehicleType());
        double taxes = fixedCost * .18;
        invoice.setUsageCharges(fixedCost);
        invoice.setTaxes(taxes);
        invoice.setTotal(fixedCost + taxes);
        return invoice;
    }
}
