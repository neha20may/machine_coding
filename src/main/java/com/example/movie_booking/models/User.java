package com.example.movie_booking.models;

public class User {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
