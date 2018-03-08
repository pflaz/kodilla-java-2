package com.kodilla.good.patterns.challenges.food2door;

public class OrderFromExtraFoodShop implements Order {

    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Ordering from " + orderRequest.getProvider().getName());
        System.out.println("Product name: " + orderRequest.getProduct().getName());
        System.out.println("Quantity: " + orderRequest.getQuantity());
        System.out.print("Priority delivery: ");
        if (orderRequest instanceof OrderRequestFromExtraFoodShop) {
            if (((OrderRequestFromExtraFoodShop) orderRequest).isPriorityDelivery()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }
        return true;
    }
}
