package com.morening.java.learn.model;

import com.morening.java.learn.game.IPlayer;

public class Message {

    public IPlayer target = null;
    public Move move = null;

    public Message(IPlayer target, Move move){
        this.target = target;
        this.move = move;
    }
}
