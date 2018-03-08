package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public String getShapeName() {
        return "triangle";
    }

    public double getField() {
        if (base <= 0 || height <= 0) { return 0;}
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        return "name: " + getShapeName() + " / Field: " + getField();
    }
}
