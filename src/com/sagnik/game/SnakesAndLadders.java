package com.sagnik.game;

import com.sagnik.manager.BoardManager;
import com.sagnik.manager.TurnManager;
import com.sagnik.model.Player;

import java.util.ArrayList;
import java.util.List;

public class SnakesAndLadders implements Game {

    private BoardManager boardManager;

    private TurnManager turnManager;

    private boolean hasEnded;

    public SnakesAndLadders(int players) {
        List<Player> playerList = new ArrayList<>();
        for(int i=0; i<players; i++){
            playerList.add(new Player(i+1));
        }
        this.turnManager = new TurnManager(playerList, players*30);
        this.boardManager = new BoardManager(10, 10, 5, 5);
        this.hasEnded = false;
    }

    @Override
    public void start(){
        while(!hasEnded && !turnManager.turnsExhausted()){
            Player player = turnManager.getCurrentPlayer();
            int playerRoll = turnManager.roll();
            System.out.println(String.format("Player %s rolls die scoring %s", player.getId(), playerRoll));
            int nextIndex = player.getCurrentCell()+playerRoll;
            if(boardManager.isFinalCell(nextIndex)){
                player.setCurrentCell(boardManager.getFinalCellIndex());
                System.out.println("#######################################");
                System.out.println(String.format("Player %s has won!", player.getId()));
                System.out.println("#######################################");
                this.stop();
            }else if(boardManager.hasSnake(nextIndex)){
                System.out.println(String.format("Player %s has landed on a snake!", player.getId()));
                int snakeTail = boardManager.getSnakeTail(nextIndex);
                player.setCurrentCell(snakeTail);
            }else if(boardManager.hasLadder(nextIndex)){
                System.out.println(String.format("Player %s has landed on a ladder!", player.getId()));
                int ladderTop = boardManager.getLadderTop(nextIndex);
                player.setCurrentCell(ladderTop);
            }else{
                player.setCurrentCell(nextIndex);
            }
        }
        turnManager.printStatus();
    }

    @Override
    public void stop(){
        this.hasEnded = true;
    }
}
