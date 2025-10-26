package com.kodilla.good.patterns.strategy.social;

public class User {

    private String name;
    private SocialPublisher socialPublisher;

    public User(String name, SocialPublisher socialPublisher) {
        this.name = name;
        this.socialPublisher = socialPublisher;
    }

    public String getName() {
        return name;
    }

    public String sharePost() {
        return socialPublisher.share();
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
