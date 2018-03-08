package com.kodilla.good.patterns.challenges.food2door;

public class OrderProcessor {
    public boolean process(OrderRequest orderRequest) {
        Order order;
        if (orderRequest.getProvider().getName().equals("ExtraFoodShop")) {
            order = new OrderFromExtraFoodShop();
        } else if (orderRequest.getProvider().getName().equals("GlutenFreeShop")) {
            order = new OrderFromGlutenFreeShop();
        } else if (orderRequest.getProvider().getName().equals("HealthyShop")) {
            order = new OrderFromHealthyShop();
        } else {
            return false;
        }
        return order.process(orderRequest);
    }
}
