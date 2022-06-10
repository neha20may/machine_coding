package com.example.movie_booking.service;

import com.example.movie_booking.models.Seat;
import com.example.movie_booking.models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class UserManagement {
    private static final AtomicInteger count = new AtomicInteger(0);
    //Assume all Users are registered, authenticated, and logged in to the Application.
    Map<String, User> users;
    Iterator it;
    public UserManagement(Map<String, User> users) {
        this.users = users;
        setIt();
    }

    public void setIt() {
        this.it=users.entrySet().iterator();
    }

    public User getNextUser() {
        User u;
        Map.Entry<String, User> entry= (Map.Entry<String, User>) it.next();
        u=users.get(entry.getKey());
//        it.next();
        return u;

    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public UserManagement() {
        createUsers();
    }

    public void createUsers(){
        User u1=new User(String.valueOf(count.getAndIncrement()), "ram");
        User u2=new User(String.valueOf(count.getAndIncrement()), "shyam");
        User u3=new User(String.valueOf(count.getAndIncrement()), "sita");
        User u4=new User(String.valueOf(count.getAndIncrement()), "radha");
        User u5=new User(String.valueOf(count.getAndIncrement()), "meera");
        users= new HashMap<>();
        users.put(u1.getId(), u1);
        users.put(u2.getId(), u2);
        users.put(u3.getId(), u3);
        users.put(u4.getId(), u4);
        users.put(u5.getId(), u5);
        setIt();

    }
}
