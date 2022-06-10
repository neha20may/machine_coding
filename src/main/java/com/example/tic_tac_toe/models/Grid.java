package com.example.tic_tac_toe.models;

import com.example.tic_tac_toe.enums.Symbol;

import java.util.ArrayList;

public class Grid {
    //TODO: where do you write this constant 3?
    // We can harcode it here in grid or take input from user/interviewer and set it
    int N;
    //Make Sure to write either the consructor or restBoard to initialise the board.
    //for example  boxes[0][0] = new Box(new Rook(true), 0, 0); I seem to forgot to initialise mu grid/board.
    Cell [][] board;
    //TODO: not sure where to keep pieces/symbols
    // Piece goes in Cell.

    ArrayList<Cell> emptyCells;

    public ArrayList<Cell> getEmptyCells() {
        return emptyCells;
    }

    public void setEmptyCells(ArrayList<Cell> emptyCells) {
        this.emptyCells = emptyCells;
    }

    public void setN(int n) {
        N = n;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public Grid() {
    }

    public Grid(int n, Cell[][] grid) {
        N = n;
        this.board = grid;
        //ideally here you sbould wirte grid[i][j]=new Cell() stuff;
    }

    public void printGrid(){
        for(Cell[] cr: board){
            for(Cell c: cr){
                System.out.print(c.piece);
            }
            System.out.println();
        }
    }

    public int getN() {
        return N;
    }

    public Cell[][] getBoard() {
        return board;
    }

}

