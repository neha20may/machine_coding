package com.example.snake_ladder.models;

public class CellBuilder {
    private int value;
    private int i;
    private int j;
    private boolean isLadderStart;
    private boolean isSnakeStart;
    private int snakeEnd;
    private int ladderEnd;
    private int snakeStart;
    private int ladderStart;

    public CellBuilder setValue(int value) {
        this.value = value;
        return this;
    }

    public CellBuilder setI(int i) {
        this.i = i;
        return this;
    }

    public CellBuilder setJ(int j) {
        this.j = j;
        return this;
    }

    public CellBuilder setIsLadderStart(boolean isLadderStart) {
        this.isLadderStart = isLadderStart;
        return this;
    }

    public CellBuilder setIsSnakeStart(boolean isSnakeStart) {
        this.isSnakeStart = isSnakeStart;
        return this;
    }

    public CellBuilder setSnakeEnd(int snakeEnd) {
        this.snakeEnd = snakeEnd;
        return this;
    }

    public CellBuilder setLadderEnd(int ladderEnd) {
        this.ladderEnd = ladderEnd;
        return this;
    }

    public CellBuilder setSnakeStart(int snakeStart) {
        this.snakeStart = snakeStart;
        return this;
    }

    public CellBuilder setLadderStart(int ladderStart) {
        this.ladderStart = ladderStart;
        return this;
    }

    public Cell createCell() {
        return new Cell(value, i, j, isLadderStart, isSnakeStart, snakeEnd, ladderEnd, snakeStart, ladderStart);
    }
}