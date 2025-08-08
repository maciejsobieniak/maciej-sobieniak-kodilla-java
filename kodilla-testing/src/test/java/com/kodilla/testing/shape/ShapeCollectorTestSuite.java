package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


@DisplayName("TDD: Shape Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Start tests shape module");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests for shape module are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for Circle")
    class TestCircleShapeCollector {

        @Test
        void testAddFigureCircle() {
            Circle circle = new Circle("Circle1", 21.02);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureCircle() {
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            boolean result = shapeCollector.removeFigure(0);
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureCircle() {
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            boolean result = shapeCollector.removeFigure(1);
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureCircle() {
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            Shape retrivedCircle = shapeCollector.getFigure(0);
            Assertions.assertEquals(circle, retrivedCircle);
        }

        @Test
        void testGetNotExistingFigureCircle() {}


    }

    @Nested
    @DisplayName("Tests for Square")
    class TestSquareShapeCollector {

        @Test
        void testAddFigureSquare() {
            Square square = new Square("Square1", 21.02);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureSquare() {
            Square square = new Square("Square1", 21.02);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            boolean result = shapeCollector.removeFigure(0);
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureSquare() {
            Square square = new Square("Square1", 21.02);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            boolean result = shapeCollector.removeFigure(1);
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureSquare() {
            Square square = new Square("Square1", 21.02);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(square);

            Shape retrivedSquare = shapeCollector.getFigure(0);
            Assertions.assertEquals(square, retrivedSquare);
        }
    }

    @Nested
    @DisplayName("Tests for Triangle")
    class TestTriangleShapeCollector {

        @Test
        void testAddFigureTriangle() {
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureTriangle() {
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            boolean result = shapeCollector.removeFigure(0);
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureTriangle() {
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            boolean result = shapeCollector.removeFigure(1);
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureTriangle() {
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);

            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(triangle);

            Shape retrivedTriangle = shapeCollector.getFigure(0);
            Assertions.assertEquals(triangle, retrivedTriangle);
        }
    }

    @Nested
    @DisplayName("Tests for Shape Collector - getFigures")
    class TestShapeCollector {

        @Test
        void testGetFigures() {
            ShapeCollector shapeCollector = new ShapeCollector();

            shapeCollector.addFigure(new Circle("Circle1", 21.02));
            shapeCollector.addFigure(new Square("Square1", 21.02));
            shapeCollector.addFigure(new Triangle("Triangle1", 21.02, 10));
            StringBuilder result = new StringBuilder();
            result.append("Shape nr: " + 1 + " - " + "Nazwa: " + "Circle1" + " - " + "Pole: " + 1388.0825546991755 + "\n");
            result.append("Shape nr: " + 2 + " - " + "Nazwa: " + "Square1" + " - " + "Pole: " + 441.8404 + "\n");
            result.append("Shape nr: " + 3 + " - " + "Nazwa: " + "Triangle1" + " - " + "Pole: " + 15.51 + "\n");

            Assertions.assertEquals(result.toString(), shapeCollector.getFigures().toString());

        }

        @Test
        void testGetNullFigures() {
            ShapeCollector shapeCollector = new ShapeCollector();
            Assertions.assertNull(shapeCollector.getFigures());
        }

        @Test
        void testAddNullFigure() {

            ShapeCollector shapeCollector = new ShapeCollector();
            boolean result = shapeCollector.addFigure(null);

            Assertions.assertFalse(result);
        }
    }
}



