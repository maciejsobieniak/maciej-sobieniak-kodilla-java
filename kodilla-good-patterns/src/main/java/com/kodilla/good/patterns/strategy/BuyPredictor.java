package com.kodilla.good.patterns.strategy;

public sealed interface BuyPredictor
        permits AggressivePredictor, ConservativePredictor, BalancedPredictor {

    String predictWhatToBuy();
}
