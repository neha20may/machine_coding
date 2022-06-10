package com.example.split_wise.models;

import com.example.split_wise.enums.ExpenseType;

import java.util.ArrayList;

public class Expense {
    int amount;
    ExpenseType type;
    ArrayList<Integer> percentage;
    ArrayList<Integer> excactAmounts;

    public ArrayList<Integer> getExcactAmounts() {
        return excactAmounts;
    }

    public void setExcactAmounts(ArrayList<Integer> excactAmounts) {
        this.excactAmounts = excactAmounts;
    }

    public ArrayList<Integer> getPercentage() {
        return percentage;
    }

    public void setPercentage(ArrayList<Integer> percentage) {
        this.percentage = percentage;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Expense(int amount, ExpenseType type) {
        this.amount = amount;
        this.type = type;
    }
}
