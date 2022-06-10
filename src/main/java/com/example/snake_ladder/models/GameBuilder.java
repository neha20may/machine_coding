package com.example.snake_ladder.models;

import com.example.snake_ladder.enums.GameStatus;

import java.util.List;

public class GameBuilder {
    private Board board;
    List<Player> players;
    GameStatus status;
    int noPlayers;

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameBuilder setBoard(int cellCount) {
        int size = (int) Math.sqrt(cellCount);
        Cell[] board = new Cell[101];
        board[0] = null;
        for (int i = 1; i <= 100; i++) {
            int row = (i - 1) / size;
            int col = (i - 1) % size;
            Cell cell = new CellBuilder().setI(row).setJ(col).setValue(i).createCell();
            board[i] = cell;
        }

        Board b = new Board();
        b.setBoard(board);
        this.board = b;
        return this;
    }

    public GameBuilder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public GameBuilder setSnakes(List<Snake> snakes) {
        this.board.setSnakes(snakes);
        for (Snake sn : snakes) {
            int start = sn.start;
            int end = sn.end;
            Cell cell = board.getCell(start);
            cell.setSnakeStart(start);
            cell.setSnakeEnd(end);
            cell.isSnakeStart = true;
        }
        return this;
    }

    public GameBuilder setLadders(List<Ladder> ladders) {
        this.board.setLadders(ladders);
        for (Ladder ld : ladders) {
            int start = ld.start;
            int end = ld.end;
            Cell cell = board.getCell(start);
            cell.setLadderStart(start);
            cell.setLadderEnd(end);
            cell.isLadderStart = true;
        }
        return this;
    }

    public GameBuilder setStatus(GameStatus status) {
        this.status = status;
        return this;
    }

    public GameBuilder setNoPlayers(int noPlayers) {
        this.noPlayers = noPlayers;
        return this;
    }

    public Game createGame() {
        return new Game(board, players, status, noPlayers);
    }
}