package com.morening.java.learn.game;

import com.morening.java.learn.util.GameUtil;
import com.morening.java.learn.util.RecordLogger;

import java.io.IOException;

public class Game {
    public static final int MAX_BOARD_SIZE = 15;
    public static final char MARK = '+';

    private IPlayer player1 = null;
    private IPlayer player2 = null;

    private char[][] board = null;

    public void setPlayer1(IPlayer player) {
        this.player1 = player;
    }

    public void setPlayer2(IPlayer player) {
        this.player2 = player;
    }

    public void start() {
        if (player1 == null || player2 == null){
            return;
        }
        if (player1 instanceof Computer && player2 instanceof Computer){
            player2.setPlayerMark('T');
        }
        if (player1 instanceof Human && player2 instanceof Human){
            player2.setPlayerName("玩家");
            player2.setPlayerMark('M');
        }
        player1.setEnemyMark(player2.getPlayerMark());
        player2.setEnemyMark(player1.getPlayerMark());
        try {
            RecordLogger.getInstance().setFilePath("record.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = 0;
        while (true){
            int[] move = new int[2];
            if (!player1.makeDecision(board, move)){
                continue;
            }
            count++;
            printBoard(board, move);
            RecordLogger.getInstance().doLogging(RecordLogger.getLoggingMsg(board, move[0], move[1]));
            if (count >= MAX_BOARD_SIZE*MAX_BOARD_SIZE){
                System.out.println("平局");
                break;
            }
            if (GameUtil.isFiveInARow(board, move, board[move[0]][move[1]])){
                System.out.println(String.format("%s 先手获胜", player1.getPlayerName()));
                break;
            }
            if (!player2.makeDecision(board, move)){
                continue;
            }
            count++;
            printBoard(board, move);
            RecordLogger.getInstance().doLogging(RecordLogger.getLoggingMsg(board, move[0], move[1]));
            if (GameUtil.isFiveInARow(board, move, board[move[0]][move[1]])){
                System.out.println(String.format("%s 后手获胜", player2.getPlayerName()));
                break;
            }
        }
    }

    private void printBoard(char[][] board, int[] move){
        System.out.println(String.format("落子位置 (%d, %d)", move[0], move[1]));
        System.out.print("     ");
        for (int j=0; j<MAX_BOARD_SIZE; j++){
            if (j < 10){
                System.out.print(" "+j+" ");
            } else {
                System.out.print(j+" ");
            }
        }
        System.out.println();
        System.out.print("     ");
        System.out.println("---------------------------------------------");
        for (int i=0; i<MAX_BOARD_SIZE; i++){
            if (i < 10){
                System.out.print(i+"  | ");
            } else {
                System.out.print(i+" | ");
            }
            for (int j=0; j<MAX_BOARD_SIZE; j++){
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void init() {
        board = new char[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
        for (int i=0; i<MAX_BOARD_SIZE; i++){
            for (int j=0; j<MAX_BOARD_SIZE; j++){
                board[i][j] = MARK;
            }
        }
    }
}
