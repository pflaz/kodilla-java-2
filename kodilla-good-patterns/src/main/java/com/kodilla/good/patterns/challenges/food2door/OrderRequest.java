package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequest {

    private Provider provider;
    private Product product;
    private int quantity;

    public OrderRequest(Provider provider, Product product, int quantity) {
        this.provider = provider;
        this.product = product;
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
