package com.example.movie_booking.models;

import java.util.Date;

public class Show {
    String showId;
    Movie movie;
    Date startTime;
    Date endTime;
    double duration;

    public Show(String showId, Movie movie, Date startTime,  double duration) {
        this.showId = showId;
        this.movie = movie;
        this.startTime = startTime;
//        this.endTime = endTime;
        this.duration = duration;
//        this.screen = screen;
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public double getDuration() {
        return duration;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    Screen screen;

}
