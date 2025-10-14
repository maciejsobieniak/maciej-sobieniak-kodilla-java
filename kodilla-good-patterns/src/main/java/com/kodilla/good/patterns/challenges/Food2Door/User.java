package com.kodilla.good.patterns.challenges.Food2Door;

public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getUserName() {
        return name;
    }

    public String getUserSurname() {
        return surname;
    }
}
