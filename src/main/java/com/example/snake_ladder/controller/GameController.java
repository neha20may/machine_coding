package com.example.snake_ladder.controller;

import com.example.snake_ladder.enums.GameStatus;
import com.example.snake_ladder.models.*;

import java.util.ArrayList;

import static com.example.snake_ladder.enums.GameStatus.Active;
import static com.example.snake_ladder.enums.GameStatus.Ended;


public class GameController {

    public static void startGame(ArrayList<Player> players, ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        //Reset prior Game.
        //Builder has something for reset too
        Game game= new GameBuilder()
                .setBoard(100)
                .setLadders(ladders)
                .setPlayers(players)
                .setSnakes(snakes)
                .setStatus(Active)
                .setNoPlayers(2).createGame();

        PlayerStrategy strategy= new PlayerStrategy();
        for(Player pl: players){
            pl.setStrategy(strategy);
        }
        int turn=-1;
        while(game.getStatus()!=Ended){
            turn= (turn+1)%(game.getNoPlayers());
            Player p= players.get(turn);
            System.out.print(p.getName()+" ");
            p.move(game);
            if(p.isWon()){
                game.setStatus(Ended);
                System.out.println(p.getName()+" wins the game");
            }
        }
    }


    public static void endGame() {
        //Abrupt ending
        //can store the game status and stats of player and release the resources.

    }
}

