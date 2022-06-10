package com.example.split_wise;

import com.example.split_wise.models.ExpenseCommand;
import com.example.split_wise.models.ICommand;
import com.example.split_wise.models.ShowCommand;
import com.example.split_wise.models.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        //create a few users in driver
        User u1 = new User("1", "neha", "@", "123");
        User u2 = new User("2", "love1", "@", "123");
        User u3 = new User("3", "love2", "@", "123");
        User u4 = new User("4", "love3", "@", "123");
        //Equivalent to database
        HashMap<String, User> userMap = new HashMap<>();
        userMap.put(u1.getUserID(), u1);
        userMap.put(u2.getUserID(), u2);
        userMap.put(u3.getUserID(), u3);
        userMap.put(u4.getUserID(), u4);

        //TODO: Command line pattern for reading commands and showing balance.
        //https://refactoring.guru/design-patterns/command/java/example
        FileInputStream f= new FileInputStream("C:/Users/neha2/IdeaProjects/machine_coding/src/main/resources/static/split_wise/commands");
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String command=scanner.nextLine();
            System.out.println("Processing command "+command);
            ICommand cmd;
            if (command.contains("SHOW")) {
                cmd = new ShowCommand(command, userMap);
                cmd.execute();
            }
            if (command.contains("EXPENSE")) {
                cmd = new ExpenseCommand(command, userMap);
                cmd.execute();
            }
        }
    }
}
