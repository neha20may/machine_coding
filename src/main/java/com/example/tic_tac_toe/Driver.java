package com.example.tic_tac_toe;
import com.example.tic_tac_toe.models.Player;
import com.example.tic_tac_toe.service.GameService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream("C:/Users/neha2/IdeaProjects/Snake_Ladder/src/main/resources/static/snake_ladder/tic_tac_toe/tic_tac_toe");
        Scanner scan = new Scanner(in);
        String name = scan.next();
        String symbol=scan.next();
        Player p1 = new Player(name, symbol);
        name = scan.next();
        symbol=scan.next();
        Player p2 = new Player(name, symbol);
        ArrayList<Player> players=new ArrayList(Arrays.asList(p1,p2));
        int gridSize=3;
        GameService.startGame(2, players, gridSize);

    }

}

