package com.kodilla.good.patterns.challenges.orders;

public interface Repository {
    boolean add(OrderRequest orderRequest);
    void show();
}
