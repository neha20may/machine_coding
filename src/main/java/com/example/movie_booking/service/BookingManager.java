package com.example.movie_booking.service;

import com.example.movie_booking.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static com.example.movie_booking.constants.CONSTANT.maxRetryPay;
//TODO: is booking manager singleton? if yes, is that okay? is the system highly scalable?
public class BookingManager {
    PaymentService paymentService;
    HashMap<Show, List<Seat>> avSeats;

    public BookingManager() {
        setAvSeats();
        paymentService = new PaymentService();
    }

    public void setAvSeats() {


    }

    public Ticket book(User user, Show show, int noOfSeats) {
        //1. get screen that has the particular seat and movie
        //2.book it
        //Once a User selects a particular show to book tickets for, a UserBookingSession starts.
        //Within this UserBookingSession, a User will be
        // able to get the Available Seats for the show and select the Seats he wishes to book. It is a ‘good to have’ for the Application to have limits on the number of seats a User can book in a Ticket.
        //TODO: What is start a session ? taking lock on resources ? //db lock software lock? tardeoff
        List<Seat> availableSeats = getAvailableSeats(show);
        if (noOfSeats > availableSeats.size())
            throw new IllegalStateException("Required number of seats are not available");
        List<Seat> selectedSeats;

        synchronized(this) {
            System.out.println("selecting seats user id=" + user.getId());
            selectedSeats = selectSeats(availableSeats, noOfSeats);
            System.out.println("selected seats");
            changeSeatStatus(selectedSeats, SeatAvailabiltyType.TEMPORARILY_UNAVAILABLE);
            System.out.println("changed them to temp avalailble");
        }

        Ticket ticket = null;

        if (payment(user, selectedSeats)) {
            ticket = generateTicket(selectedSeats, show, user);
            String msg = ticket.printTicket();
            System.out.println(msg);
            changeSeatStatus(selectedSeats, SeatAvailabiltyType.FILLED);
        } else {
            System.out.println("booking cant be done at the moment, plz try payment");
            int retryCount = 0;
            while (retryCount < maxRetryPay) {
                payment(user, selectedSeats);
            }
        }
        if (ticket == null) {
            changeSeatStatus(selectedSeats, SeatAvailabiltyType.AVAILABLE);
        }
        return ticket;
    }

    private void changeSeatStatus(List<Seat> selectedSeats, SeatAvailabiltyType seatAvailabiltyType) {
        for (Seat seat : selectedSeats) {
            seat.setSeatAvailabiltyType(seatAvailabiltyType);
        }
    }

    private boolean payment(User user, List<Seat> selectedSeats) {
        return paymentService.pay(user, selectedSeats);
    }

    private Ticket generateTicket(List<Seat> selectedSeats, Show show, User user) {
        Ticket ticket = new Ticket();
        ticket.setTickerId(Ticket.count.getAndIncrement());
        ticket.setShow(show);
        ticket.setSeats(selectedSeats);
        ticket.setUser(user);
        ticket.saveDb();
        return ticket;
    }

    private List<Seat> selectSeats(List<Seat> availableSeats, int noOfSeats) {
        //change the selected seats type to temporary available
        //select random seats
        //Ideally inout from user
        List<Seat> selectedSeats = new ArrayList<>();
//        Random r = new Random();
        int n = 0;
        while (selectedSeats.size() < noOfSeats) {
            Seat seat = availableSeats.get(n++);
            selectedSeats.add(seat);
        }
        return selectedSeats;
    }

    private synchronized List<Seat> getAvailableSeats(Show show) {
        //TODO: get it from db
        //<show id, ....no of seats..> free filled available
        Screen screen = show.getScreen();
        //TODO: does it return copy or reference of the same seats?
        List<Seat> seats = screen.getSeats();
        List<Seat> avlSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (seat.getSeatAvailabiltyType() == SeatAvailabiltyType.AVAILABLE)
                avlSeats.add(seat);
        }
        return avlSeats;

    }
}
