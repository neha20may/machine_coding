package com.example.tic_tac_toe.models;

import java.util.ArrayList;
import java.util.Random;

public class PlayerStrategy extends IStrategy {
    @Override
    public Cell move(Cell cell, Grid board) {
        //this random behaviour can go in loop
        //need to store empty cells.
        ArrayList<Cell> emptyCells=board.getEmptyCells();
        int i=0;
        int j=emptyCells.size();
        Random r= new Random();
        int next=r.nextInt(j)+i;
        Cell nextCell=emptyCells.get(next);
        return nextCell;
    }
}
