package com.kodilla.good.patterns.challenges.orders;

public class MailService implements InformationService {


    @Override
    public boolean sendConfirmation(OrderRequest orderRequest) {
        System.out.println("Email confirmation of order " + orderRequest.getProduct().getName() + " has been send to: " + orderRequest.getUser().getEmail());
        return true;
    }
}
