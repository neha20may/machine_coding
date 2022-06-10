package com.example.split_wise.models;

import java.util.*;

//TODO does this class need ot be singleton?
public class UserRelationShipManager {
    Graph g;
    static UserRelationShipManager url;

    private UserRelationShipManager() {
        g = new Graph(10);
    }

    public static UserRelationShipManager getInstance() {
        if (url == null) {
            url = new UserRelationShipManager();
            return url;
        } else
            return url;
    }

    public void setBorrowedFrom(User from, User to, int amount) {
        g.addEdge(from, to, amount);
        g.addEdge(to, from, -amount);

    }

    public String oweTo(User u) {
        String message = "";
        for (Map.Entry entry : g.getAdj().entrySet()) {
            User v = (User) entry.getKey();
            List<Edge> edges = g.getEdges(v);
            for (Edge e : edges) {
                if (e.getTo() == u) {
                    if (e.getAmount() > 0)
                        message += e.getTo().getUserID() + " owes " + e.getFrom().getUserID() + " : " + e.getAmount() + "\n";
                }
            }
        }
        return message;
    }

    public String paidBy(User u) {
        List<Edge> edges = g.getEdges(u);
        String message = "";
        for (Edge e : edges) {
            if (e.getFrom() == e.getTo())
                continue;
            if (e.getAmount() > 0) {
                message += e.getTo().getUserID() + " owes " + e.getFrom().getUserID() + " : " + e.getAmount() + "\n";
            }
        }
        return message;
    }

    public String paidBy() {
        String message = "";
        for (Map.Entry entry : g.getAdj().entrySet()) {
            User u = (User) entry.getKey();
            message += paidBy(u);

        }
        return message;
    }

}
