package com.example.split_wise.services;

import com.example.split_wise.models.Expense;
import com.example.split_wise.models.User;
import com.example.split_wise.enums.ExpenseType;
import com.example.split_wise.models.UserRelationShipManager;

import java.util.*;

public class ExpenseService {
    public ExpenseService() {
        ur= UserRelationShipManager.getInstance();
    }

    //TODO: what kinda relationship is between user and amount
    UserRelationShipManager ur;
    public  boolean addAmount(User user, Expense exp, ArrayList<User> sharingUsers) {
        //add
        user.setAmount(-exp.getAmount());

        //split
        return split(user, exp, sharingUsers);
    }

    public boolean verifySplit(Expense expense, User u1, ArrayList<User> users) {
        //TODO
            return false;
    }

    public  boolean split(User user, Expense expense, ArrayList<User> users) {
        if (expense.getType() == ExpenseType.EQUAL) {
            int amount = expense.getAmount();
            int N = users.size();
            for (User u : users) {
                int borrowedAmount=amount / N;
                u.setAmount(borrowedAmount);
                ur.setBorrowedFrom(user, u, borrowedAmount);
            }

        }
        if (expense.getType() == ExpenseType.PERCENT) {
            int amount = expense.getAmount();
            int N = users.size();
            Iterator<Integer> it = expense.getPercentage().iterator();
            for (User u : users) {
                int borrowedAmount=amount * it.next() / 100;
                u.setAmount(borrowedAmount);
                ur.setBorrowedFrom(user, u, borrowedAmount);
            }
        }
        if (expense.getType() == ExpenseType.EXACT) {
            int amount = expense.getAmount();
            int N = users.size();
            Iterator<Integer> it = expense.getExcactAmounts().iterator();
            for (User u : users) {
                int borrowedAmount=it.next();
                u.setAmount(borrowedAmount);
                ur.setBorrowedFrom(user, u, borrowedAmount);
            }

        }
        return true;
    }


}

