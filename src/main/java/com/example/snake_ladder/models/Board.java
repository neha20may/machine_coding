package com.example.snake_ladder.models;

import java.util.List;

/**
 * In workat.tech board has snakes, ladders and player pieces. Makes more sense.
 * I wrote them in Game.
 */
public class Board {
    Cell[] board;
    List<Snake> snakes;
    List<Ladder> ladders;

    public void setBoard(Cell[] board) {
        this.board = board;
    }

    public Board() {
    }

    private Board(Cell[] board,  List<Snake> snakes, List<Ladder> ladders) {
        this.board = board;
        this.snakes = snakes;
        this.ladders = ladders;
    }



    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Cell getCell(int i) {
        Cell c = board[i];
        return c;
    }
}
