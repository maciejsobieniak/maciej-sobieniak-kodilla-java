package com.kodilla.good.patterns.strategy.social;

public class YGeneration extends User {

    public YGeneration(String name) {
        super(name, new TwitterPublisher());
    }
}
