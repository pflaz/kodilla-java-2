package com.kodilla.good.patterns.challenges.orders;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(OrderRequest orderRequest) {
        System.out.println("Product " + orderRequest.getProduct().getName() + " has been ordered by " + orderRequest.getUser().getName());
        return true;
    }

}
