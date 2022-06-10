package com.example.movie_booking.ticketbookinglowlevelsystemdesign.providers;

import com.example.movie_booking.ticketbookinglowlevelsystemdesign.model.Seat;
import com.example.movie_booking.ticketbookinglowlevelsystemdesign.model.Show;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seat, String user);
    void unlockSeats(Show show, List<Seat> seat, String user);
    boolean validateLock(Show show, Seat seat, String user);

    List<Seat> getLockedSeats(Show show);
}
