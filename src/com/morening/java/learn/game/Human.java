package com.morening.java.learn.game;

import java.util.Scanner;

public class Human implements IPlayer {

    private String NAME = "人类";
    private char MARK = 'H';
    private char ENEMY_MARK = Game.MARK;

    private Scanner sc = null;

    public Human(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public boolean makeDecision(char[][] board, int[] move) {
        System.out.println(String.format("请 %s 决定落子位置：", NAME));
        int row = sc.nextInt();
        int col = sc.nextInt();
        if (row >= 0 && row < Game.MAX_BOARD_SIZE
                && col >= 0 && col < Game.MAX_BOARD_SIZE
                && board[row][col] == Game.MARK){
            board[row][col] = MARK;

            move[0] = row;
            move[1] = col;
            return true;
        }

        return false;
    }

    @Override
    public String getPlayerName() {

        return NAME;
    }

    @Override
    public char getPlayerMark() {

        return MARK;
    }

    @Override
    public void setEnemyMark(char mark) {
        this.ENEMY_MARK = mark;
    }

    @Override
    public void setPlayerName(String name) {
        NAME = name;
    }

    @Override
    public void setPlayerMark(char mark) {
        MARK = mark;
    }
}
