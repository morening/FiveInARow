package com.morening.java.learn.util;

public class DecisionLogger extends FileLogger{

    private static final String LOGGER_NAME = "decision";
    private static DecisionLogger sInstance = null;

    public static DecisionLogger getInstance(){
        if (sInstance == null){
            sInstance = new DecisionLogger();
        }

        return sInstance;
    }

    private DecisionLogger(){
        init(LOGGER_NAME);
    }

    public static String getLoggingMsg(char[][] board, int score, int enemy_score) {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format("Computer: %d  Human: %d  Evaluate: %d\n", score, enemy_score, (score - enemy_score)));

        sb.append(FileLogger.convertBoard2Msg(board));

        return sb.toString();
    }
}
