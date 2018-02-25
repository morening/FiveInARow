package com.morening.java.learn;

import com.morening.java.learn.game.Computer;
import com.morening.java.learn.game.Game;
import com.morening.java.learn.game.Human;

import java.util.Scanner;

public class FiveInARow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        game.init();
        game.setPlayer1(new Human(sc));
        game.setPlayer2(new Computer(3));
        game.start();
    }
}
