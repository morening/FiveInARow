package com.morening.java.learn;

import java.util.Arrays;

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

        int count = 0;
        while (true){
            int[] move = new int[2];
            if (!player1.makeDecision(board, move)){
                continue;
            }
            count++;
            printBoard(board, move);
            if (count >= MAX_BOARD_SIZE*MAX_BOARD_SIZE){
                System.out.println("平局");
                break;
            }
            if (isGameOver(board, move)){
                System.out.println(String.format("%s 先手获胜", player1.getPlayerName()));
                break;
            }
            if (!player2.makeDecision(board, move)){
                continue;
            }
            count++;
            printBoard(board, move);
            if (isGameOver(board, move)){
                System.out.println(String.format("%s 后手获胜", player2.getPlayerName()));
                break;
            }
        }
    }

    private boolean isGameOver(char[][] board, int[] move) {
        char mark = board[move[0]][move[1]];
        int[] count = new int[4];
        Arrays.fill(count, 1);
        count[0] += countRow(board, move[0], move[1], -1, 0, mark);
        count[1] += countRow(board, move[0], move[1], -1, 1, mark);
        count[2] += countRow(board, move[0], move[1], 0, 1, mark);
        count[3] += countRow(board, move[0], move[1], 1, 1, mark);
        count[0] += countRow(board, move[0], move[1], 1, 0, mark);
        count[1] += countRow(board, move[0], move[1], 1, -1, mark);
        count[2] += countRow(board, move[0], move[1], 0, -1, mark);
        count[3] += countRow(board, move[0], move[1], -1, -1, mark);

        for (int k=0; k<4; k++){
            if (count[k] >= 5){
                return true;
            }
        }

        return false;
    }

    private int countRow(char[][] board, int row, int col, int offset_row, int offset_col, char mark){
        if (row+offset_row >= 0 && row+offset_row < Game.MAX_BOARD_SIZE
                && col+offset_col >= 0 && col+offset_col < Game.MAX_BOARD_SIZE
                && board[row+offset_row][col+offset_col] == mark){
            return countRow(board, row+offset_row, col+offset_col, offset_row, offset_col, mark) + 1;
        }
        return 0;
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
