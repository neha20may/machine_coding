package com.example.zoom_car.carrental.src.service;

import com.example.zoom_car.carrental.src.model.reservation.ReservationReminder;

public interface BookingReminderService {
    void notifyUser(ReservationReminder reservationReminder);
}
