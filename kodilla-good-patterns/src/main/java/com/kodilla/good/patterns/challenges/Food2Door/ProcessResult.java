package com.kodilla.good.patterns.challenges.Food2Door;

public class ProcessResult {
    private final boolean success;
    private final String message;

    public ProcessResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}

