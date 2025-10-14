package com.kodilla.good.patterns.challenges.Food2Door.ProducerStore;

import com.kodilla.good.patterns.challenges.Food2Door.Producer;
import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.ProcessResult;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtraFoodShop implements Producer {

    private final String producerName;
    private final List<String> availableProducts = Arrays.asList("Milk", "Bread", "Eggs");
    private final Map<String, Integer> stock = new HashMap<>();
    private static final int MIN_ORDER = 1;
    private static final int MAX_ORDER = 10;
    private static final int DISCOUNT_THRESHOLD = 8;

    public ExtraFoodShop(String producerName) {
        this.producerName = producerName;
        // Inicjalizacja stanu magazynowego
        stock.put("Milk", 10);
        stock.put("Bread", 5);
        stock.put("Eggs", 20);
    }

    public String getProducerName() {
        return producerName;
    }

    @Override
    public ProcessResult process(Product product, int quantity) {
        String name = product.getProductName();
        if (!availableProducts.contains(name)) {
            return new ProcessResult(false, "Produkt " + name + " nie jest dostępny w ExtraFoodShop.");
        }
        if (quantity < MIN_ORDER) {
            return new ProcessResult(false, "Minimalna ilość zamówienia to " + MIN_ORDER + ".");
        }
        if (quantity > MAX_ORDER) {
            return new ProcessResult(false, "Maksymalna ilość zamówienia to " + MAX_ORDER + ".");
        }
        int currentStock = stock.getOrDefault(name, 0);
        if (currentStock < quantity) {
            return new ProcessResult(false, "Brak wystarczającej ilości produktu " + name + ". Dostępne: " + currentStock);
        }
        StringBuilder msg = new StringBuilder();
        if (quantity >= DISCOUNT_THRESHOLD) {
            msg.append("Otrzymujesz rabat na duże zamówienie! ");
        }
        stock.put(name, currentStock - quantity);
        msg.append("Zamówienie na " + quantity + " szt. produktu " + name + " zostało zrealizowane przez ExtraFoodShop.");
        return new ProcessResult(true, msg.toString());
    }
}
