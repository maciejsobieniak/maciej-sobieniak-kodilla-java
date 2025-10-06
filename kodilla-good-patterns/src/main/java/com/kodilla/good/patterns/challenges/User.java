package com.kodilla.good.patterns.challenges;

public class User {

    private String login;
    private String name;
    private String surname ;
    private String mail;

    public User(String login, String name, String surname, String mail) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
    }

    public String getUserLogin() {
        return login;
    }

    public String getUserFullName() {
        return name + " " + surname;
    }

    public String getUserSurname() {
        return surname;
    }

    public String getUserName() {
        return name;
    }

    public String getUserEmail() {
        return mail;
    }
}
