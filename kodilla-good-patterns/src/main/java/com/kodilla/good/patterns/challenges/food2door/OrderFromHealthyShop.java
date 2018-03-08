package com.kodilla.good.patterns.challenges.food2door;

public class OrderFromHealthyShop implements Order {
    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Ordering from " + orderRequest.getProvider().getName());
        System.out.println("Product name: " + orderRequest.getProduct().getName());
        System.out.println("Quantity: " + orderRequest.getQuantity());

        return true;
    }
}
