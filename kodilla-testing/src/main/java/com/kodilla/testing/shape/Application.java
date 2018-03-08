package com.kodilla.testing.shape;

public class Application {

    public static void main(String[] args) {

        ShapeCollector shapeCollector = new ShapeCollector();

        Square square = new Square(3.0);
        Circle circle = new Circle(6.0);
        Triangle triangle = new Triangle(4.0, 5.0);


        System.out.println("Adding figures...");
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);

        System.out.println("Number of figures in collection: " + shapeCollector.getFiguresCount());
        shapeCollector.showFigures();

        System.out.println("Getting first figure");
        Shape theShape = shapeCollector.getFigure(0);
        System.out.println(theShape);

        System.out.println("Removing figures...");
        shapeCollector.removeFigure(square);
        shapeCollector.removeFigure(circle);
        shapeCollector.removeFigure(triangle);

        System.out.println("Number of figures in collection:" + shapeCollector.getFiguresCount());
        shapeCollector.showFigures();
    }
}
