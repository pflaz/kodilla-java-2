package com.kodilla.good.patterns.challenges.food2door;

public class Product {
    private String name;
    private boolean isGlutenFree;

    public Product(String name, boolean isGlutenFree) {
        this.name = name;
        this.isGlutenFree = isGlutenFree;
    }

    public String getName() {
        return name;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }
}
