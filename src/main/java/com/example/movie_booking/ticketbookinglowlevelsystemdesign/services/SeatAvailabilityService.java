package com.example.movie_booking.ticketbookinglowlevelsystemdesign.services;

import com.example.movie_booking.ticketbookinglowlevelsystemdesign.model.Seat;
import com.example.movie_booking.ticketbookinglowlevelsystemdesign.model.Show;
import com.example.movie_booking.ticketbookinglowlevelsystemdesign.providers.SeatLockProvider;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {
    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(@NonNull final BookingService bookingService,
                                   @NonNull final SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(@NonNull final Show show) {
        final List<Seat> allSeats = show.getScreen().getSeats();
        final List<Seat> unavailableSeats = getUnavailableSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(unavailableSeats);
        return availableSeats;
    }

    private List<Seat> getUnavailableSeats(@NonNull final Show show) {
        final List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
        unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
        return unavailableSeats;
    }

}
