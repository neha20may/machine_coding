package com.example.tic_tac_toe.models;

import com.example.tic_tac_toe.enums.Symbol;

public class Cell {
    //TODO: player owns the symbol or cell owns the symbol?
    // In chess this CEll contains a piece which is of type Piece. All pieces king, etc inherit Piece.
    // A piece can have a method to tell canMove() tocheck if the piece can move ;
    boolean occupied;

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    int row, col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isOccupied() {
        return occupied;
    }

    Symbol piece;

    public Cell(int r, int c) {
        this.row=r;
        this.col=c;
        this.occupied = false;
        this.piece = Symbol._;
    }


    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setPiece(Symbol piece) {
        this.piece = piece;
    }


    public Symbol getPiece() {
        return piece;
    }
}
