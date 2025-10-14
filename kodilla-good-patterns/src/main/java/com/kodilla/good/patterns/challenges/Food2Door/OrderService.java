package com.kodilla.good.patterns.challenges.Food2Door;

public interface OrderService {
    ProcessResult order(User user, Producer producer, Product product, int quantity);
}
