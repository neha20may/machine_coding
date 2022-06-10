package com.example.split_wise.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Graph {
    int V;

    public void setVertices(User u) {
        this.vertices.put(u.getUserID(), u);
    }

    Map<String, User> vertices;

    public Map getVertices() {
        return vertices;
    }

    int E;

    public HashMap<User, List<Edge>> getAdj() {
        return adj;
    }

    public void setAdj(HashMap<User, List<Edge>> adj) {
        this.adj = adj;
    }

    HashMap<User, List<Edge>> adj;

    public Graph(int v) {
        V = v;
        this.adj = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addEdge(User u, User v, double amount) {
        //add both ways
        setVertices(u);
        setVertices(v);

        List<Edge> edges = null;
        edges = adj.get(u);
        if (edges == null) {
            adj.put(u, new ArrayList<Edge>());
            adj.get(u).add(new Edge(u, v, amount));
        } else {
            Edge forwardEdge = null;
            for (Edge e : edges) {
                if (e.getTo() == v) {
                    forwardEdge = e;
                    break;
                }
            }
            if (forwardEdge == null) {
                adj.get(u).add(new Edge(u, v, amount));
            } else {
                forwardEdge.setAmount(forwardEdge.getAmount() + amount);
            }
        }

    }

    public List<Edge> getEdges(User u) {
       return this.getAdj().get(u);
    }
}
