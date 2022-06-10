package com.example.tic_tac_toe.service;

import com.example.tic_tac_toe.enums.GameStatus;
import com.example.tic_tac_toe.models.*;

import java.util.ArrayList;

import static com.example.tic_tac_toe.enums.GameStatus.Ended;

public class GameService {
    public static void startGame(int N, ArrayList<Player> players, int gridSize) {
        GameBuilder gameBuilder = new GameBuilder();
        Game game = gameBuilder.
                setStatus(GameStatus.Active)
                .setNoPlayers(N)
                .setGrid(gridSize)
                .setTurn(0)
                .createGame();
        //also clear the moves if there is list of moves in game.

//TODO: where do all those 9 pieces kep ? 5X and 4
// Piece is a class and cell keeps a piece. so the information goes there.
        Grid grid = gameBuilder.getGrid();
        grid.printGrid();

        IStrategy strategy = new PlayerStrategy();
        for (Player p : players) {
            p.setStrategy(strategy);
        }

        int turn = 1;
        while (game.getStatus() != Ended) {
            turn = (turn + 1) % N;
            Player p = players.get(turn);
            System.out.print(p.getName() + " " + p.getPiece() + " playing from " + p.getCurCEll().getRow() + "," + p.getCurCEll().getCol());
            if (p.move(game.getGrid())) {
                grid.printGrid();
                if (game.isWon(p)) {
                    game.setStatus(Ended);
                    System.out.println(p.getName() + " has won");
                    break;
                }
            } else {
                System.out.println();
                System.out.println("No one won");
                break;
            }

        }


    }
}
