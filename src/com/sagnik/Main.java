package com.sagnik;

import com.sagnik.game.Game;
import com.sagnik.game.SnakesAndLadders;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of players :");
        if(in.hasNextInt()) {
            int players = in.nextInt();
            Game game = new SnakesAndLadders(players);
            game.start();
        }else{
            System.out.println("Invalid input! Exiting...");
        }
    }
}
