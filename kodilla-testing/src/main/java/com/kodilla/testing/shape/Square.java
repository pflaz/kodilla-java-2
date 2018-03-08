package com.kodilla.testing.shape;

public class Square implements Shape {

    private double side;
    private String name = "square";

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public String getShapeName() {
        return name;
    }

    public double getField() {
        if (side <= 0) {return 0;}
        return side * side;
    }

    @Override
    public String toString() {
        return "name: " + getShapeName() + " / Field: " + getField();
    }
}
