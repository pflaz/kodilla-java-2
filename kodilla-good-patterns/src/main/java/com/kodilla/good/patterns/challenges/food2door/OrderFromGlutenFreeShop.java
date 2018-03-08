package com.kodilla.good.patterns.challenges.food2door;

public class OrderFromGlutenFreeShop implements Order {
    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Ordering from " + orderRequest.getProvider().getName());
        System.out.println("Product name: " + orderRequest.getProduct().getName());
        System.out.println("Quantity: " + orderRequest.getQuantity());

        if (orderRequest.getProduct().isGlutenFree()) {
            System.out.println("Gluten-free product ordered - the price will be reduced by 10%");
        } else {
            System.out.println("Ordered product is not gluten-free, please consider to buy gluten-free product which price is reduced by 10%");
        }
        return true;
    }
}
