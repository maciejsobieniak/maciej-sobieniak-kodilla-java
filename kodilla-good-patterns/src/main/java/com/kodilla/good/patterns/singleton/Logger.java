package com.kodilla.good.patterns.singleton;

public enum Logger {

    INSTANCE;

    private String lastLog = "";

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }

    public void closeLogger() {
        lastLog = null;
        System.out.println("Logger closed.");
    }
}
