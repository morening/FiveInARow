package com.morening.java.learn.game;

import com.morening.java.learn.model.Move;

public interface IPlayer {

    boolean makeDecision(char[][] board, Move move, Move next);

    String getPlayerName();

    void setPlayerName(String name);

    char getPlayerMark();

    void setPlayerMark(char mark);

    void setEnemyMark(char mark);
}
