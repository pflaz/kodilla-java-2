package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getShapeName() {
        return "circle";
    }

    public double getField() {
        if (radius <= 0) {return 0;}
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "name: " + getShapeName() + " / Field: " + getField();
    }

}
