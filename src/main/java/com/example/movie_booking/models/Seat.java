package com.example.movie_booking.models;

public class Seat {
    int seatNo;
    SeatType type;
    SeatAvailabiltyType seatAvailabiltyType;

    public Seat(int seatNo, SeatType type, SeatAvailabiltyType seatAvailabiltyType) {
        this.seatNo = seatNo;
        this.type = type;
        this.seatAvailabiltyType = seatAvailabiltyType;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public SeatAvailabiltyType getSeatAvailabiltyType() {
        return seatAvailabiltyType;
    }

    public void setSeatAvailabiltyType(SeatAvailabiltyType seatAvailabiltyType) {
        this.seatAvailabiltyType = seatAvailabiltyType;
    }


}
