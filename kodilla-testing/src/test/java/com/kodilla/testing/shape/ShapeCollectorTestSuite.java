package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCouter = 0;

    @BeforeClass
    public static void beforeTests() {
        System.out.println("Begin tests");
    }

    @AfterClass
    public static void afterTests() {
        System.out.println("Tests finished");
    }

    @Before
    public void before() {
        testCouter++;
        System.out.println("Test number: " + testCouter);
    }

    @Test
    public void testAddFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5.0);
        Shape circle = new Circle(3.0);
        Shape triangle = new Triangle(4.0, 5.0);

        //When
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);

        //Then
        Assert.assertEquals(3, shapeCollector.getFiguresCount());
    }

    @Test
    public void testSquareField() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5.0);

        //When
        double result = square.getField();

        //Then
        Assert.assertTrue(Math.abs(25.0 - result) < 0.1); //due to 'double' precision

    }

    @Test
    public void testCircleField() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Circle(5.0);

        //When
        double result = square.getField();

        //Then
        Assert.assertTrue(Math.abs(25 * Math.PI - result) < 0.1); //due to 'double' precision
    }

    @Test
    public void testTriangleField() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Triangle(5, 3);

        //When
        double result = square.getField();

        //Then
        Assert.assertTrue(Math.abs(7.5 - result) < 0.1); //due to 'double' precision
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        shapeCollector.addFigure(square);

        //When
        boolean result = shapeCollector.removeFigure(square);

        //Then
        Assert.assertEquals(0, shapeCollector.getFiguresCount());
        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        shapeCollector.addFigure(square);

        //When
        Shape retrievedShape = shapeCollector.getFigure(0);

        // Then
        Assert.assertEquals(square, retrievedShape);

    }

    @Test
    public void testShapesNames() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5.0);
        Shape circle = new Circle(3.0);
        Shape triangle = new Triangle(4.0, 5.0);

        //Then
        String squareName = square.getShapeName();
        String circleName = circle.getShapeName();
        String triangleName = triangle.getShapeName();

        //When
        Assert.assertEquals("square", squareName);
        Assert.assertEquals("circle", circleName);
        Assert.assertEquals("triangle", triangleName);

    }




}
