package com.morening.java.learn.model;

import com.morening.java.learn.game.IPlayer;

public interface OnOutputListener {

    void onOutput(IPlayer player, Move move);
}
