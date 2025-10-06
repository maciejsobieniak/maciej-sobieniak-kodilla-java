package com.kodilla.good.patterns.challenges;

public class CategoryProduct {
    private String categoryName;
    private Product product;

    public CategoryProduct(String categoryName, Product product) {
        this.categoryName = categoryName;
        this.product = product;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Product getProduct() {
        return product;
    }
}
