package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.model.account.User;
import com.example.zoom_car.carrental.src.model.common.NotificationStatus;
import com.example.zoom_car.carrental.src.model.reservation.InvoiceNotification;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;
import com.example.zoom_car.carrental.src.repository.UserRepository;
import com.example.zoom_car.carrental.src.repository.VehicleReservationRepository;

public class InvoiceNotificationServiceImpl implements InvoiceNotificationService {

    public void notifyUser(InvoiceNotification invoiceNotification) {
        VehicleReservation vehicleReservation = VehicleReservationRepository.vehicleReservationMap
                .get(invoiceNotification.getReservationId());
        User user = UserRepository.userUserIdMap.get(vehicleReservation.getUsrId());
        System.out.println("Notification sent " + user.getContact().getEmail());
        invoiceNotification.setNotificationStatus(NotificationStatus.SENT);
    }
}
