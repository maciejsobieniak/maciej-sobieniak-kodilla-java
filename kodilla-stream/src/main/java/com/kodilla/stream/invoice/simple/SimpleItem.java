package com.kodilla.stream.invoice.simple;
/**
 * SimpleItem class represents an item in an invoice, consisting of a product and its quantity.
 * It provides methods to retrieve the product, quantity, and calculate the total value of the item.
 */
public class SimpleItem {
    private final SimpleProduct product;
    private final double quantity;

    public SimpleItem(final SimpleProduct product, final double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getValue() {
        return product.getProductPrice() * quantity;
    }
}
