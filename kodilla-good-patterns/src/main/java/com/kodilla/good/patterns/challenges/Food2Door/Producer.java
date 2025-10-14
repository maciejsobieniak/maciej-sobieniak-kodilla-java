package com.kodilla.good.patterns.challenges.Food2Door;

public interface Producer {
    ProcessResult process(Product product, int quantity);
    String getProducerName();
}
