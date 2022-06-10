package com.example.split_wise.services;

import com.example.split_wise.models.User;
import com.example.split_wise.models.UserRelationShipManager;

public class ShowService {
    //TODO: What kinda relation is there between users
// A user can owe to many users and can be owed to by many users; many to many relationship. How do we dsign it? liek social media ?

    public UserRelationShipManager getUr() {
        return ur;
    }

    public void setUr(UserRelationShipManager ur) {
        this.ur = ur;
    }

    public ShowService() {
        this.ur = UserRelationShipManager.getInstance();
    }

    UserRelationShipManager ur;


    public void show(User user) {
        System.out.print(ur.paidBy(user));
        System.out.print(ur.oweTo(user));


    }

    public void show() {
        System.out.println(ur.paidBy());
    }
}
