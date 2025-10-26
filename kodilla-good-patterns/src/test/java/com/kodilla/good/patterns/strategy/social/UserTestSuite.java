package com.kodilla.good.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User maciej = new Millenials("Maciej");
        User konrad = new YGeneration("Konrad");
        User gosia = new ZGeneration("Gosia");
        // When
        String maciejSharingSocial = maciej.sharePost();
        System.out.println("Maciej post on: " + maciejSharingSocial);
        String konradSharingSocial = konrad.sharePost();
        System.out.println("Konrad post on: " + konradSharingSocial);
        String gosiaSharingSocial = gosia.sharePost();
        System.out.println("Gosia post on: " + gosiaSharingSocial);
        // Then
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User maciej = new Millenials("Maciej");
        // When
        String maciejSharingSocial = maciej.sharePost();
        System.out.println("Maciej post on: " + maciejSharingSocial);
        maciej.setSocialPublisher(new TwitterPublisher());
        maciejSharingSocial = maciej.sharePost();
        System.out.println("Maciej post on: " + maciejSharingSocial);
        // Then
        assertEquals("Twitter", maciejSharingSocial);
    }

}
