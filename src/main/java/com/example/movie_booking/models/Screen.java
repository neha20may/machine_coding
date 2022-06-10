package com.example.movie_booking.models;

import java.util.*;


public class Screen {
    String screenId;
    //Shows for different movies
    // Screen run one show right? 1:1
    HashMap<Date, Show> showSchedule; //saved in db
    Show curShow;
    List<Seat> seats;

    public String getScreenId() {
        return screenId;
    }

    public HashMap<Date, Show> getShowSchedule() {
        return showSchedule;
    }

    public Show getCurShow() {
        return curShow;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Screen() {
        //TODO: init from db
        this.screenId = "1";
        this.showSchedule = new HashMap<>();

        Show show = new Show("1", new Movie("Wakeup Sid"), new Date(), 1.5);
        show.setScreen(this);

        showSchedule.put(new Date(), show);

        this.curShow = show;

        List<Seat> seats = new ArrayList<>();
        Seat seat = new Seat(1, SeatType.FRONT, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        seat = new Seat(2, SeatType.FRONT, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        seat = new Seat(3, SeatType.MIDDLE, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        seat = new Seat(4, SeatType.MIDDLE, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        seat = new Seat(5, SeatType.BACK, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        seat = new Seat(6, SeatType.BACK, SeatAvailabiltyType.AVAILABLE);
        seats.add(seat);
        this.seats = new ArrayList<Seat>();

        this.seats.addAll(seats);
        Collections.synchronizedList(this.seats);
    }

    public Screen(String screenNo, HashMap<Date, Show> pastShows, Show curShow, List<Seat> seats) {
        this.screenId = screenNo;
        this.showSchedule = pastShows;
        this.curShow = curShow;
        this.seats = seats;
    }

    //arrangement of seats that can be booked by users
    //TODO: feels like it shall be id, list of sheets hashmap or so
//    List<Seat> seats;

}
