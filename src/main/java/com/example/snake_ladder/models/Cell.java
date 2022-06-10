package com.example.snake_ladder.models;

public class Cell {
    int value;
    int row, col;
    boolean isLadderStart;
    boolean isSnakeStart;
    int snakeEnd;
    int ladderEnd;

    public Cell(int value, int row, int col, boolean isLadderStart, boolean isSnakeStart, int snakeEnd, int ladderEnd, int snakeStart, int ladderStart) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.isLadderStart = isLadderStart;
        this.isSnakeStart = isSnakeStart;
        this.snakeEnd = snakeEnd;
        this.ladderEnd = ladderEnd;
        this.snakeStart = snakeStart;
        this.ladderStart = ladderStart;
    }

    public void setLadderStart(boolean ladderStart) {
        isLadderStart = ladderStart;
    }

    public void setSnakeStart(boolean snakeStart) {
        isSnakeStart = snakeStart;
    }

    public void setSnakeEnd(int snakeEnd) {
        this.snakeEnd = snakeEnd;
    }

    public void setLadderEnd(int ladderEnd) {
        this.ladderEnd = ladderEnd;
    }

    public void setSnakeStart(int snakeStart) {
        this.snakeStart = snakeStart;
    }

    public void setLadderStart(int ladderStart) {
        this.ladderStart = ladderStart;
    }

    int snakeStart;
    int ladderStart;

    public int getSnakeEnd() {
        return snakeEnd;
    }

    public int getLadderEnd() {
        return ladderEnd;
    }

    public int getSnakeStart() {
        return snakeStart;
    }

    public int getLadderStart() {
        return ladderStart;
    }

    public boolean isSnakeStart() {
        return isSnakeStart;
    }

    public boolean isLadderStart() {
        return isLadderStart;
    }



    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }


}
