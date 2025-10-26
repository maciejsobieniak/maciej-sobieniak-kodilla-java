package com.kodilla.good.patterns.strategy.social;

public class ZGeneration extends User {

    public ZGeneration(String name) {
        super(name, new SnapchatPublisher());
    }
}
