package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> figures = new ArrayList<Shape>();


    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        if (figures.contains(shape)) {
            figures.remove(shape);
            return true;
        } else {
            return false;
        }
    }

    public Shape getFigure(int n) {
        Shape shape = null;
        if (figures.size() > n) {
            shape = figures.get(n);
        }
        return shape;

    }

    public void showFigures() {
        int counter = 0;
        for(Shape theShape :figures) {
            counter++;
            System.out.println("Shape #" + counter);
            System.out.println(theShape.getShapeName());
            System.out.println("Field: " + theShape.getField());
            System.out.println();
        }

    }

    public int getFiguresCount() {
        return figures.size(); //tmp
    }
}
