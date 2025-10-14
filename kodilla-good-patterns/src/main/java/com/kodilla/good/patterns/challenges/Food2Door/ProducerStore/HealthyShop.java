package com.kodilla.good.patterns.challenges.Food2Door.ProducerStore;

import com.kodilla.good.patterns.challenges.Food2Door.Producer;
import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.ProcessResult;

public class HealthyShop implements Producer {

    private String producerName;

    public HealthyShop(String producerName) {
        this.producerName = producerName;
    }

    public String getProducerName() {
        return producerName;
    }

    @Override
    public ProcessResult process(Product product, int quantity) {
        String message = "HealthyShop: Order for " + quantity + " of " + product.getProductName() + " has been processed.";
        return new ProcessResult(true, message);
    }
}
