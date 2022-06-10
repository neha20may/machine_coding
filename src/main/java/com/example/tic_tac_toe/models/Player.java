package com.example.tic_tac_toe.models;

//import com.example.snake_ladder.models.Board;

import com.example.tic_tac_toe.enums.Symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    //A player can extend an Account as well. Something as parent so that there is possibility of multiple paayers of diff kind, comp player human player.
    String name;
    //Ideally pieces are in Cell. Here it can work in this game as there re only two possibilities : X, O.
    //In chess there are many pieces so only one variable like white or black is assigned to player.
    //It could be boolean isX or so also.
    Symbol piece;

    public Cell getCurCEll() {
        return curCEll;
    }

    Cell curCEll;
    Cell nextCell;

    public Player(String name, Symbol piece, Cell curPos, IStrategy strategy) {
        this.name = name;
        this.piece = piece;
        this.curCEll = curPos;
        this.strategy = strategy;
    }

    public void setCurCEll(Cell curCEll) {
        this.curCEll = curCEll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPiece(Symbol piece) {
        this.piece = piece;
    }

    public void setStrategy(IStrategy iStrategy) {
        this.strategy = iStrategy;
    }

    IStrategy strategy;

    public Player(String name, String s) {
        this.name = name;
        if (s.equals("X"))
            this.piece = Symbol.X;
        else if (s.equals("O"))
            this.piece = Symbol.O;
        curCEll = new Cell(-1, -1);
    }
//TODO: is this "win" property of player or game?
// I guess it shall be part of Game. there it needs palyer , here it needs game.


    //TODO: what is the right way for writing moves of a player? what is the relationship how classes/objects are combined, figure it out from google
    //In educative chess, Move is a separate class. I make a Strategy thing here.
    //There a move class has Player, CEll(Box) Start, end, PieceMoved, etc.
    //Probably we can make Move a service or so.
    //TODO: what is the relation between move and player and game then in UML?
    // Educative: Game contains a move just like it has board. and move is made by player(how?)
    //there is playermove and makeMove function in Game class (not GameService)

    /**
     * !!! There are two ways to use strategy pattern. !!!
     * A move is a strategy and a strategy is called with a context.
     * A caller makes context and then context calls strategy.
     * Now a context can be a player or a Game.
     * if Game calls strategy then context is player and board
     * if players calls strategy then context is just board.
     *
     * @param Grid board
     * @return
     */
    public boolean move(Grid board) {
        if (board.getEmptyCells().size() == 0)
            return false;
        nextCell = strategy.move(curCEll, board);
        System.out.println(" to " + nextCell.getRow() + "," + nextCell.getCol());
        board.getEmptyCells().remove(nextCell);
        nextCell.setPiece(this.piece);
        curCEll = nextCell;
        return true;
    }

    public String getName() {
        return name;
    }

    public Symbol getPiece() {
        return piece;
    }


    public IStrategy getStrategy() {
        return strategy;
    }
}
