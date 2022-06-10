package com.example.snake_ladder;

import com.example.snake_ladder.controller.GameController;
import com.example.snake_ladder.models.Ladder;
import com.example.snake_ladder.models.Player;
import com.example.snake_ladder.models.Snake;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//@SpringBootApplication
public class SnakeLadderApplication {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("C:/Users/neha2/IdeaProjects/Snake_Ladder/src/main/resources/static/snake_ladder/game_input.txt");
        Scanner scan = new Scanner(in);
        int noSnake = scan.nextInt();
        ArrayList<Snake> snakes = new ArrayList<Snake>();
        for (int i = 0; i < noSnake; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            Snake snake = new Snake(start, end);
            snakes.add(snake);
        }
        int noLadders = scan.nextInt();
        ArrayList<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < noLadders; i++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            Ladder ladder = new Ladder(start, end);
            ladders.add(ladder);
        }
        int noPlayers = scan.nextInt();
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noPlayers; i++) {
            String name = scan.next();
            Player p = new Player(name);
            players.add(p);
        }
        GameController.startGame(players, snakes, ladders);

    }

}
