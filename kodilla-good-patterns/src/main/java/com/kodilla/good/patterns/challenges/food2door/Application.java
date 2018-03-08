package com.kodilla.good.patterns.challenges.food2door;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        List<OrderRequest> orderRequests = orderRequestRetriever.retrieve();

        for (OrderRequest orderRequest : orderRequests) {
            OrderProcessor orderProcessor = new OrderProcessor();
            orderProcessor.process(orderRequest);
        }
    }
}
