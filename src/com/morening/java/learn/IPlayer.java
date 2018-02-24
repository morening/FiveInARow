package com.morening.java.learn;

public interface IPlayer {

    boolean makeDecision(char[][] board, int[] move);

    String getPlayerName();

    void setPlayerName(String name);

    char getPlayerMark();

    void setPlayerMark(char mark);

    void setEnemyMark(char mark);
}
