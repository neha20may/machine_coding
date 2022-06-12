package com.example.zoom_car.carrental.test.service;

import com.example.zoom_car.carrental.src.exceptions.InvalidVehicleIdException;
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
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InvoiceBuilderUtilTest {
    @Test
    public void shouldBuildCancelledInvoice()
            throws VehicleBookedException, InvalidVehicleIdException {
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
        VehicleReservation vehicleReservation =
                userService.scanToReserve(vehicleList.get(1).getQrCode(), user.getId());

        vehicleReservation = userService.cancel(vehicleReservation.getReservationId());

        Invoice invoice = InvoiceBuilderUtil.buildCancelledInvoice(vehicleReservation);

        assertNotNull(invoice);
        assertEquals(invoice.getUsageCharges(), 50);
        assertEquals(invoice.getTaxes(), 9);
        assertEquals(invoice.getTotal(), 59);
    }
}
