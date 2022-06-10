package com.example.split_wise.models;

import com.example.split_wise.enums.ExpenseType;
import com.example.split_wise.services.ExpenseService;

import java.util.*;

public class ExpenseCommand extends ICommand {
    Expense exp;
    User u1;
    ArrayList<User> sharingUsers;
    static ExpenseService amountService;

    public ExpenseCommand(String cmd) {
        super(cmd);
        parse();
        amountService= new ExpenseService();
    }

    public ExpenseCommand(String command, HashMap<String, User> userMap) {
        super(command);
        this.userMap = userMap;
        parse();
        amountService= new ExpenseService();
    }

    @Override
    public void parse() {
        String[] cmdParts = this.command.split(" ");
        Iterator<String> it= Arrays.stream(cmdParts).iterator();
        it.next();
        u1 = this.userMap.get(it.next());
        int amount = Integer.parseInt(it.next());
        int usersCount = Integer.parseInt(it.next());
        int count = 1;
        sharingUsers = new ArrayList<>();
        while (count <= usersCount) {
            User u = this.userMap.get(it.next());
            sharingUsers.add(u);
            count++;
        }
        ExpenseType type = ExpenseType.valueOf(it.next());
        exp = new Expense(amount, type);
        ArrayList<Integer> numbers=new ArrayList<>();
        count=1;

        if(type==ExpenseType.EXACT){
            while(count<=usersCount){
                String aa=it.next();
                Integer a=Integer.valueOf(aa);
                numbers.add(a);
                count++;
            }
            exp.setExcactAmounts(numbers);
        }
        count=1;
        if(type==ExpenseType.PERCENT){
            while(count<=usersCount){
                String aa=it.next();
                Integer a=Integer.valueOf(aa);
                numbers.add(a);
                count++;
            }
            exp.setPercentage(numbers);
        }
    }

    @Override
    public boolean execute() {
        return amountService.addAmount(u1, exp, sharingUsers);
    }
}
