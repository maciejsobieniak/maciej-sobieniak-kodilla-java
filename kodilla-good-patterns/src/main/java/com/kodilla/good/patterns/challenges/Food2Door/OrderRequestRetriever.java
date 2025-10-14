package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.ProducerStore.ExtraFoodShop;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "Doe");
        Producer producer = new ExtraFoodShop("Extra Food Shop");
        Product product = new Product("Milk");
        int quantity = 1;
        return new OrderRequest(user, producer, product, quantity);
    }
}
