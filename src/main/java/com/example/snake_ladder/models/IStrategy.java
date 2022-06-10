package com.example.snake_ladder.models;

abstract public class IStrategy {
    public abstract int move(int cellPosition, Game game);
}
