package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.ProducerStore.*;

public class ProducerOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Producer producer, Product product, int quantity) {
        System.out.println("Order created: " + quantity + " of " + product.getProductName() + " from " + producer.getProducerName() + " for " + user.getUserName());
    }
}
