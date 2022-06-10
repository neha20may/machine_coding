package com.example.split_wise.models;

import com.example.split_wise.services.ShowService;

import java.util.HashMap;

public class ShowCommand extends ICommand {
    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    User u;

    public ShowCommand(String cmd, HashMap<String, User> userMap) {
        super(cmd);
        this.userMap=userMap;
        parse();
    }

    @Override
    public boolean execute() {
        //TODO: There can be only one show service , right
        ShowService showService = new ShowService();
        if (u != null) {
            showService.show(u);
        } else {
            showService.show();
        }
        return true;
    }

    @Override
    public void parse() {
        String[] cmdParts = this.command.split(" ");
        if (cmdParts.length == 2)
            u = this.userMap.get(cmdParts[1]);
    }
}
