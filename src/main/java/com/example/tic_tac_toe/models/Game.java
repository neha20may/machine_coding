package com.example.tic_tac_toe.models;

import com.example.tic_tac_toe.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Grid grid;
    int noPlayers;
    int turn;
    GameStatus status;
    //You can also keep track of moves played
    //List<Move> movesplayed. Now the Move class is needed separately.

    public Grid getGrid() {
        return grid;
    }

    public int getNoPlayers() {
        return noPlayers;
    }

    public int getTurn() {
        return turn;
    }

    public GameStatus getStatus() {
        return status;
    }

    Game(Grid grid, int noPlayers, int turn, GameStatus status) {
        this.grid = grid;
        this.noPlayers = noPlayers;
        this.turn = turn;
        this.status = status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }
    //Builder of game takes care of all initialisation.

    //IF mover were here; taking chess move example here

    /**
     * public boolean playerMove(Player player, int startx, int starty, int endx, int endy){
     * Cell start=getCell(startx, starty)
     * Cell end=getCell(endx, endy)
     * Move move=new Move(player, start, end)
     * returnt this.makeMove(move, player)
     * }
     * <p>
     * private boolean  makeMove(Move move, Player player){
     * Piece sourcePiece=move.getStart().getPiece()
     * if(sourcePiece==null)
     * return false;
     * }
     */

    public boolean isWon(Player p) {
        int N = this.grid.getN();
        //row
        boolean rowCheck = false, colCheck = false, diaCheck = false;
        for (int i = 0; i < N; i++) {
            Cell[] row = grid.getBoard()[i];
            int freq = 0;
            for (Cell cell : row) {
                if (cell.getPiece() == p.getPiece())
                    freq++;
            }
            if (freq == N)
                rowCheck = true;
        }
//col
        for (int i = 0; i < N; i++) {
            List<Cell> col = new ArrayList<Cell>();
            for (int j = 0; j < N; j++) {
                col.add(grid.getBoard()[j][i]);
            }
            int freq = 0;
            for (Cell cell : col) {
                if (cell.getPiece() == p.getPiece())
                    freq++;
            }
            if (freq == N)
                colCheck = true;
        }
//diag
        for (int i = 0; i < N - 1; i++) {
            if (grid.getBoard()[i][i] == grid.getBoard()[i + 1][i + 1] && grid.getBoard()[i][i].piece == p.getPiece()) {
                diaCheck = true;
            } else {
                diaCheck = false;
            }
        }
        for (int i = N - 1; i > 0; i--) {
            if (grid.getBoard()[i][i] == grid.getBoard()[i - 1][i - 1] && grid.getBoard()[i][i].piece == p.getPiece()) {
                diaCheck = true;
            } else {
                diaCheck = false;
            }
        }
        return (rowCheck || colCheck || diaCheck);

    }
}
