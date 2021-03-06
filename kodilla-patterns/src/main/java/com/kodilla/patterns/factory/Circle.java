package com.kodilla.patterns.factory;

public class Circle implements Shape {
    private final String name;
    private final double radius;

    public Circle(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    @Override
    public double getCircumfence() {
        return 2 * Math.PI * radius;
    }
}
