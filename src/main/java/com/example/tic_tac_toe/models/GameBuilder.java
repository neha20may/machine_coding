package com.example.tic_tac_toe.models;

import com.example.tic_tac_toe.enums.GameStatus;

import java.util.ArrayList;
import java.util.Arrays;

public class GameBuilder {
    private Grid grid;

    public Grid getGrid() {
        return grid;
    }

    private int noPlayers;
    private int turn;
    private GameStatus status;

    public GameBuilder setGrid(int N) {
        Grid grid=new Grid();
        Cell [][] g= new Cell[N][N];
        for(int i=0;i<3; i++){
            for(int j=0; j<3;j++){
                g[i][j]=new Cell(i,j);
            }
        }
        grid.setBoard(g);
        grid.setN(N);
        ArrayList<Cell> emptyCells = new ArrayList<>();
        for(Cell[] c: g){
            for(Cell cell: c){
                emptyCells.add(cell);
            }
        }
        grid.setEmptyCells(emptyCells);
        this.grid = grid;
        return this;
    }

    public GameBuilder setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
        return this;
    }

    public GameBuilder setTurn(int turn) {
        this.turn = turn;
        return this;
    }

    public GameBuilder setStatus(GameStatus status) {
        this.status = status;
        return this;
    }

    public Game createGame() {
        return new Game(grid, noPlayers, turn, status);
    }
}