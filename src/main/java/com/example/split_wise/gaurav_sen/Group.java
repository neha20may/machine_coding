package com.example.split_wise.gaurav_sen;

import java.util.List;

public class Group {
    String id;
//    List<Users> users;users
    //Users bloat  the cache so only keep Ids;
    List<String> users;

    public List<String> getUsers() {
        return users;
    }
}
