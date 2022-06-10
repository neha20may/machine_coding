package com.example.snake_ladder.models;

import com.example.snake_ladder.enums.GameStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static Board board;
    List<Player> players;
    GameStatus status;
    int noPlayers;

    public int getNoPlayers() {
        return noPlayers;
    }

    public void setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public static Board getBoard() {
        return board;
    }

    public Game(Board board, List<Player> players, GameStatus status, int noPlayers) {
        this.board = board;
        this.players = players;
        this.status = status;
        this.noPlayers = noPlayers;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameStatus getStatus() {
        return this.status;
    }
}
