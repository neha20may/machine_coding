package com.example.split_wise.models;

import java.util.HashMap;

public abstract class ICommand {
    String command = "";
    HashMap<String, User> userMap;

    public void setUserMap(HashMap<String, User> userMap) {
        this.userMap = userMap;
    }

    public ICommand(String command) {
        this.command = command;
    }

    public abstract boolean execute();
    public abstract void parse();
}
