package com.example.test;

import java.util.PriorityQueue;

class Test {
    public PriorityQueue<Integer> getPq() {
        return pq;
    }

    public void setPq(PriorityQueue<Integer> pq) {
        this.pq = pq;
    }

    public Test() {
        this.pq = new PriorityQueue<>(); // So different from CPP.
        //Check this https://github.com/neha20may/leetcode/blob/e7a217e729e931bad8945536f66c1960864cc138/heap/median_stream.cpp
        //for comparison!
    }

    PriorityQueue<Integer> pq;

    void addNum(int n){
        pq.add(n);
    }

}

public class Main {
    public static void main(String[] args) {
        Test t=new Test();
        PriorityQueue<Integer> pq=t.getPq(); //in CPP its not cull, it gets initialsed automatically
        t.addNum(1);

    }
}
