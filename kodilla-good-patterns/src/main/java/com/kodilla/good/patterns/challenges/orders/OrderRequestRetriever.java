package com.kodilla.good.patterns.challenges.orders;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "john@domain.com");
        Product product = new Product("pencil", 0.50, 1);
        return new OrderRequest(user, product);
    }
}
