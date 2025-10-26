package com.kodilla.good.patterns.strategy.social;

public class Millenials extends User {

    public Millenials(String name) {
        super(name, new FacebookPublisher());
    }
}
