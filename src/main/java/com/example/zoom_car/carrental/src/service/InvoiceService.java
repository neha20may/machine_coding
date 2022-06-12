package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.model.reservation.Invoice;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;

public interface InvoiceService {
    Invoice computeInvoice(VehicleReservation vehicleReservation);
}
