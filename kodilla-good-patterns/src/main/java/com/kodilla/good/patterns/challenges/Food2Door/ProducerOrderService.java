package com.kodilla.good.patterns.challenges.Food2Door;

public class ProducerOrderService implements OrderService {

    @Override
    public ProcessResult order(User user, Producer producer, Product product, int quantity) {
        return producer.process(product, quantity);
    }
}
