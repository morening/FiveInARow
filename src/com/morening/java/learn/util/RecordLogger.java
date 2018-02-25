package com.morening.java.learn.util;

public class RecordLogger extends FileLogger{

    private static final String LOGGER_NAME = "record";
    private static RecordLogger sInstance = null;

    public static RecordLogger getInstance(){
        if (sInstance == null){
            sInstance = new RecordLogger();
        }

        return sInstance;
    }

    private RecordLogger(){
        init(LOGGER_NAME);
    }

    public static String getLoggingMsg(char[][] board, int row, int col) {
        StringBuffer sb = new StringBuffer();

        sb.append(String.format("落子位置（%d, %d）\n", row, col));

        sb.append(FileLogger.convertBoard2Msg(board));

        return sb.toString();
    }
}
