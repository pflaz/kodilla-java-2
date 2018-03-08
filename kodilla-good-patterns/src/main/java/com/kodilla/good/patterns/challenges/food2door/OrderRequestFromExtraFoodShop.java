package com.kodilla.good.patterns.challenges.food2door;

public class OrderRequestFromExtraFoodShop extends OrderRequest {
    private boolean priorityDelivery;


    public OrderRequestFromExtraFoodShop(Provider provider, Product product, int quantity, boolean priorityDelivery) {
        super(provider, product, quantity);
        this.priorityDelivery = priorityDelivery;
    }

    public boolean isPriorityDelivery() {
        return priorityDelivery;
    }
}
