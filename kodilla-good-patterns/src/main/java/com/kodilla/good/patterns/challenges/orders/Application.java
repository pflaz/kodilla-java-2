package com.kodilla.good.patterns.challenges.orders;

public class Application {

    public static void main(String [] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderService(), new OrdersRepository());
        orderProcessor.process(orderRequest);

        System.out.println("Repository after ordering:");
        orderProcessor.showRepository();
    }
}
