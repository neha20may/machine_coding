package com.example.zoom_car.carrental.test.service;

import com.example.zoom_car.carrental.src.exceptions.InvalidVehicleIdException;
import com.example.zoom_car.carrental.src.exceptions.ReservationNotFoundException;
import com.example.zoom_car.carrental.src.exceptions.VehicleBookedException;
import com.example.zoom_car.carrental.src.model.account.User;
import com.example.zoom_car.carrental.src.model.reservation.Invoice;
import com.example.zoom_car.carrental.src.model.reservation.VehicleInventory;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;
import com.example.zoom_car.carrental.src.model.vehicle.HireableVehicle;
import com.example.zoom_car.carrental.src.repository.UserRepository;
import com.example.zoom_car.carrental.src.repository.VehicleInventoryRepository;
import com.example.zoom_car.carrental.src.repository.VehicleRepository;
import com.example.zoom_car.carrental.src.service.*;
import com.example.zoom_car.carrental.test.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceServiceTest {
    @AfterEach
    public void clean() {
        VehicleRepository.vehicleMap.clear();
        VehicleRepository.vehicles.clear();
        UserRepository.userMap.clear();
        UserRepository.userUserIdMap.clear();
        UserRepository.users.clear();
        VehicleInventoryRepository.vehicleInventoryList.clear();
    }

    @Test
    public void should_ComputeDailyInvoice() {
        VehicleRepository vehicleRepository = new VehicleRepository();
        User user = TestData.getUser("user@email.com");
        UserRepository.userMap.putIfAbsent("user@email.com", user);
        UserRepository.userUserIdMap.putIfAbsent(user.getId(), user);
        List<HireableVehicle> vehicleList = TestData.getHireableVehicles();
        for (HireableVehicle hireableVehicle : vehicleList) {
            vehicleRepository.addVehicle(hireableVehicle);
            VehicleInventoryRepository.vehicleInventoryList.add(new VehicleInventory(hireableVehicle));
        }
        UserService userService = new UserServiceImpl();
        VehicleReservation vehicleReservation = TestData.getVehicleReservation(user);
        InvoiceService invoiceService = new InvoiceServiceImpl();
        Invoice invoice = invoiceService.computeInvoice(vehicleReservation);
        assertNotNull(invoice);
        assertEquals(invoice.getUsageCharges(), 1600.0);
        assertEquals(invoice.getAddonCost(), 500.0);
        assertEquals(invoice.getTaxes(), 288.0);
        assertEquals(invoice.getTotal(), 1888.0);
    }

    @Test
    public void should_ComputeHourlyInvoice() throws VehicleBookedException, InvalidVehicleIdException, ReservationNotFoundException {
        VehicleRepository vehicleRepository = new VehicleRepository();
        List<HireableVehicle> vehicleList = TestData.getHireableVehicles();
        for (HireableVehicle hireableVehicle : vehicleList) {
            vehicleRepository.addVehicle(hireableVehicle);
            VehicleInventoryRepository.vehicleInventoryList.add(new VehicleInventory(hireableVehicle));
        }
        User user = TestData.getUser("user@email.com");
        UserRepository.userMap.putIfAbsent("user@email.com", user);
        UserRepository.userUserIdMap.putIfAbsent(user.getId(), user);

        UserService userService = new UserServiceImpl();
        VehicleReservation vehicleReservation =
                userService.scanToReserve(vehicleList.get(1).getQrCode(), user.getId());
        userService.returnVehicle(vehicleReservation.getReservationId(),
                vehicleList.get(1).getParkedLocation());
        InvoiceService invoiceService = new InvoiceServiceImpl();
        Invoice invoice = invoiceService.computeInvoice(vehicleReservation);
        assertNotNull(invoice);
        assertEquals(invoice.getUsageCharges(), 100);
        assertEquals(invoice.getTaxes(), 18);
        assertEquals(invoice.getTotal(), 118);
    }
}
