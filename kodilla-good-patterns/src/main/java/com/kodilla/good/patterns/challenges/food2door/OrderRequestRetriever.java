package com.kodilla.good.patterns.challenges.food2door;

import java.util.ArrayList;
import java.util.List;

public class OrderRequestRetriever {

    private Provider providerExtraFoodShop = new Provider("ExtraFoodShop");
    private Provider providerGlutenFreeShop = new Provider("GlutenFreeShop");
    private Provider providerHealthyShop = new Provider("HealthyShop");

    private Product beanBeans = new Product("Bean beans", false);
    private Product glutenFreeCrisps = new Product("Gluten-free Crisps", true);
    private Product fish = new Product("Fish", false);

    public List<OrderRequest> retrieve() {
        OrderRequest orderRequest1 = new OrderRequestFromExtraFoodShop(providerExtraFoodShop, beanBeans, 3, true);
        OrderRequest orderRequest2 = new OrderRequest(providerGlutenFreeShop, glutenFreeCrisps, 2);
        OrderRequest orderRequest3 = new OrderRequest(providerHealthyShop, fish, 4);

        List<OrderRequest> orderRequests = new ArrayList<>();
        orderRequests.add(orderRequest1);
        orderRequests.add(orderRequest2);
        orderRequests.add(orderRequest3);
        return orderRequests;
    }
}
