package com.kodilla.stream.invoice.simple;

/**
 * SimpleProduct class represents a product with a name and price.
 * It overrides the equals method to compare products based on their names.
 */
public class SimpleProduct {
    private final String productName;
    private final double productPrice;

    public SimpleProduct(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleProduct that)) return false;
        return productName.equals(that.productName);
    }
}
