package com.example.movie_booking;

import com.example.movie_booking.models.Screen;
import com.example.movie_booking.models.Show;
import com.example.movie_booking.models.User;
import com.example.movie_booking.service.BookingManager;
import com.example.movie_booking.service.UserManagement;

class RunnableUser implements Runnable {
    User u;
    Show show;
    Thread thread;
    BookingManager bm;



    public RunnableUser(User u, Show show, BookingManager bm) {
        this.u = u;
        this.show = show;
        this.bm = bm;
    }

    @Override
    public void run() {
        //Business logic
        System.out.println(u.getId() + " has elected show " + show.getMovie().getName());
        bm.book(u, show, 1);

    }

    public void start() {
        System.out.println("user  " + u.getId() + " booking ticket");
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
}

public class Driver {
    public static void main(String[] args) {
        UserManagement um = new UserManagement();
        Screen sc1= new Screen();
        BookingManager bm=new BookingManager();
        RunnableUser ru = new RunnableUser(um.getNextUser(), sc1.getCurShow(),bm);
        ru.start();
        RunnableUser ru2 = new RunnableUser(um.getNextUser(), sc1.getCurShow(), bm);
        ru2.start();
        RunnableUser ru3 = new RunnableUser(um.getNextUser(), sc1.getCurShow(), bm);
        ru3.start();

    }
}
