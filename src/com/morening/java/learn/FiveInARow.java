package com.morening.java.learn;

import com.morening.java.learn.game.Computer;
import com.morening.java.learn.game.Game;
import com.morening.java.learn.game.Human;
import com.morening.java.learn.game.IPlayer;
import com.morening.java.learn.model.Move;

import java.util.Scanner;

public class FiveInARow {

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        IPlayer player1 = new Human();
        game.setPlayer1(player1);
        game.setPlayer2(new Computer(3));
        game.start();

        Scanner sc = new Scanner(System.in);
        while (true){
            int y = sc.nextInt();
            int x = sc.nextInt();
            game.inputMove(player1, new Move(x, y));
        }
    }
}
