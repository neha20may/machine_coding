package com.example.movie_booking.ticketbookinglowlevelsystemdesign.api;

import com.example.movie_booking.ticketbookinglowlevelsystemdesign.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class MovieController {
    final private MovieService movieService;

    public String createMovie(@NonNull final String movieName) {
        return movieService.createMovie(movieName).getId();
    }

}
