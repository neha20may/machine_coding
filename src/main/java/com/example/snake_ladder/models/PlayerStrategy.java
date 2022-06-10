package com.example.snake_ladder.models;

import com.example.snake_ladder.service.DiceRoll;

public class PlayerStrategy extends IStrategy {
    @Override
    public int move(int curPos, Game game) {
        System.out.print("rolled a ");
        int no = DiceRoll.roll();
        System.out.print(no+" ");
        int nextPos = curPos + no;
        if(nextPos>100){
            nextPos=curPos;
            return nextPos;
        }
        Cell cell = game.getBoard().getCell(nextPos);
        if (cell.isSnakeStart()) {
            int snakeEnd = cell.getSnakeEnd();
            nextPos = snakeEnd;
        }
        if (cell.isLadderStart()) {
            int ladderEnd = cell.getLadderEnd();
            nextPos = ladderEnd;
        }
        System.out.println("and moved from " + curPos + " to " + nextPos);
        return nextPos;
    }
}
