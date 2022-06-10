package com.example.snake_ladder.service;

import java.util.Random;

public class DiceRoll {
    public static int roll() {
        Random rnd = new Random();
        int maximum = 6;
        int minimum = 1;
        int range = maximum - minimum + 1;
        int no = rnd.nextInt(range) + minimum;
        return no;
    }
}
