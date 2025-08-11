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
            //Given
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureCircle() {
            //Given
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);
            boolean result = shapeCollector.removeFigure(0);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureCircle() {
            //Given
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);
            boolean result = shapeCollector.removeFigure(1);

            //Then
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureCircle() {
            //Given
            Circle circle = new Circle("Circle1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);
            Shape retrivedCircle = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(circle, retrivedCircle);
        }

    }

    @Nested
    @DisplayName("Tests for Square")
    class TestSquareShapeCollector {

        @Test
        void testAddFigureSquare() {
            //Given
            Square square = new Square("Square1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureSquare() {
            //Given
            Square square = new Square("Square1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);
            boolean result = shapeCollector.removeFigure(0);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureSquare() {
            //Given
            Square square = new Square("Square1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);
            boolean result = shapeCollector.removeFigure(1);

            //Then
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureSquare() {
            //Given
            Square square = new Square("Square1", 21.02);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(square);
            Shape retrivedSquare = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(square, retrivedSquare);
        }
    }

    @Nested
    @DisplayName("Tests for Triangle")
    class TestTriangleShapeCollector {

        @Test
        void testAddFigureTriangle() {
            //Given
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCount());
        }

        @Test
        void testRemoveFigureTriangle() {
            //Given
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);
            boolean result = shapeCollector.removeFigure(0);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, shapeCollector.getShapeCount());

        }

        @Test
        void testRemoveNotExistingFigureTriangle() {
            //Given
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);
            boolean result = shapeCollector.removeFigure(1);

            //Then
            Assertions.assertFalse(result);

        }

        @Test
        void testGetFigureTriangle() {
            //Given
            Triangle triangle = new Triangle("Triangle1", 21.02, 10);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(triangle);
            Shape retrivedTriangle = shapeCollector.getFigure(0);

            //Then
            Assertions.assertEquals(triangle, retrivedTriangle);
        }
    }

    @Nested
    @DisplayName("Tests for Shape Collector - getFigures")
    class TestShapeCollector {

        @Test
        void testGetFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Circle("Circle1", 21.02));
            shapeCollector.addFigure(new Square("Square1", 21.02));
            shapeCollector.addFigure(new Triangle("Triangle1", 21.02, 10));

            //When
            StringBuilder result = new StringBuilder();
            result.append("Shape nr: " + 1 + " - " + "Nazwa: " + "Circle1" + " - " + "Pole: " + 1388.0825546991755 + "\n");
            result.append("Shape nr: " + 2 + " - " + "Nazwa: " + "Square1" + " - " + "Pole: " + 441.8404 + "\n");
            result.append("Shape nr: " + 3 + " - " + "Nazwa: " + "Triangle1" + " - " + "Pole: " + 15.51 + "\n");

            //Then
            Assertions.assertEquals(result.toString(), shapeCollector.getFigures().toString());

        }

        @Test
        void testGetNullFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //Then
            StringBuilder result = shapeCollector.getFigures();

            //Then
            Assertions.assertNull(result);
        }

        @Test
        void testAddNullFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            boolean result = shapeCollector.addFigure(null);

            //Then
            Assertions.assertFalse(result);
        }
    }
}



