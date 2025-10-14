package com.kodilla.good.patterns.challenges.Food2Door;

public interface OrderRepository {
    void createOrder(User user, Producer producer, Product product, int quantity);
}
