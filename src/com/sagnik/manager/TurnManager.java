package com.sagnik.manager;

import com.sagnik.model.Player;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TurnManager {

    private List<Player> players;

    private int turnsSoFar = 0;

    private int maxTurns;

    public TurnManager(List<Player> players, int maxTurns) {
        this.players = players;
        this.maxTurns = maxTurns;
        for(Player player : players){
            player.setInitialRoll(roll());
            System.out.println(String.format("Player %s rolls die scoring %s",player.getId(),player.getInitialRoll()));
        }
        players.sort(Comparator.comparing(Player::getInitialRoll).reversed());
        System.out.println(String.format("Player %s gets to start", players.get(0).getId()));
        System.out.println();
    }

    public Player getCurrentPlayer(){
        Player player = players.get(turnsSoFar % players.size());
        turnsSoFar++;
        return player;
    }

    public int roll(){
        Random random = new Random();
        return random.nextInt(6)+1;
    }

    public boolean turnsExhausted(){
        return turnsSoFar >= maxTurns;
    }

    public void printStatus(){
        System.out.println();
        System.out.println(String.format("Status after %s turns", turnsSoFar));
        System.out.println("------------------------------------------------------");
        for(Player player : players){
            System.out.println(String.format("Player %s is at cell %s", player.getId(), player.getCurrentCell()+1));
        }
    }
}
