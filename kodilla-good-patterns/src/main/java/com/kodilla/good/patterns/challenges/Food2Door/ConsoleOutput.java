package com.kodilla.good.patterns.challenges.Food2Door;

public class ConsoleOutput implements InformationService {

    @Override
    public void inform(User user, String message) {
        System.out.println("Informacja dla użytkownika " + user.getUserName() + " " + user.getUserSurname() + ": " + message);
    }
}