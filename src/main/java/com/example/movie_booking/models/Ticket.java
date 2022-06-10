package com.example.movie_booking.models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    public static final AtomicInteger count = new AtomicInteger(0);

    int tickerId;
    Show show;
    User user;

    public int getTickerId() {
        return tickerId;
    }

    public void setTickerId(int tickerId) {
        this.tickerId = tickerId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    List<Seat> seats;

    public String printTicket() {
        String message = "";
        message += "! ---- confirming your ticket with details --!\n";
        message += "name: " + user.getName() + " you have booked for show (movie) " + show.getMovie().getName() + " and no of seats are=" + seats.size() + ".\n";
        message += "your seats are=\n";
        for (Seat st : seats) {
            message +="Seat no=" + st.getSeatNo() + " of type " + st.getType()+"\n";
        }
        message += "your timings are " + show.getStartTime() + "\n";
        return message;
    }

    public void saveDb() {
        System.out.println("saving in db");

    }

}
