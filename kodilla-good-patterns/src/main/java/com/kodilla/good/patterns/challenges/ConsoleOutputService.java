package com.kodilla.good.patterns.challenges;

public class ConsoleOutputService implements OutputService {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}

