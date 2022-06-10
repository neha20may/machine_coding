package com.example.split_wise.models;

class Edge {
    User from;
    User to;

    public void setFrom(User from) {
        this.from = from;
    }

    public void setTo(User to) {
        this.to = to;
    }


    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    double amount;

    public Edge(User from, User to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void setAmount(double v) {
        this.amount = v;
    }
}
