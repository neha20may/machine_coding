package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.model.account.User;
import com.example.zoom_car.carrental.src.model.common.NotificationStatus;
import com.example.zoom_car.carrental.src.model.reservation.ReservationReminder;
import com.example.zoom_car.carrental.src.model.reservation.VehicleReservation;
import com.example.zoom_car.carrental.src.repository.UserRepository;
import com.example.zoom_car.carrental.src.repository.VehicleReservationRepository;

public class BookingReminderServiceImpl implements BookingReminderService {

    VehicleReservationRepository vehicleReservationRepository = new VehicleReservationRepository();

    @Override
    public void notifyUser(ReservationReminder reservationReminder) {
        VehicleReservation vehicleReservation =
                vehicleReservationRepository.getVehicleReservation(reservationReminder.getReservationId());
        User user = UserRepository.userMap.get(vehicleReservation.getUsrId());
        System.out.println("Notified user" + user.getContact().getEmail());
        reservationReminder.setNotificationStatus(NotificationStatus.SENT);
    }
}
