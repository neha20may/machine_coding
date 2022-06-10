package com.example.snake_ladder.models;

public class Player {
    public String getName() {
        return name;
    }

    String name;
    int stats;
    int cellPosition;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    IStrategy strategy;

    public Player(String name) {
        this.name = name;
        this.cellPosition=0;
    }

    /**
     * In workat.tech there is no move in player!
     * @param game
     */
    public void move(Game game) {
        cellPosition = strategy.move(cellPosition, game);
    }

    public boolean isWon() {
        if (cellPosition == 100) {
            return true;
        } else {
            return false;
        }
    }
}
