package com.kodilla.good.patterns.challenges.Food2Door;

public class OrderRequest {
    private User user;
    private Producer producer;
    private Product product;
    private int quantity;

    public OrderRequest(User user, Producer producer, Product product, int quantity) {
        this.user = user;
        this.producer = producer;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public Producer getProducer() {
        return producer;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
