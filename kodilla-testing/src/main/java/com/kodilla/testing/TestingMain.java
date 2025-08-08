package com.kodilla.testing;

import com.kodilla.testing.shape.Circle;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.shape.ShapeCollector;

public class TestingMain {
    public static void main(String[] args) {

        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle("DUna1", 21.02));
        shapeCollector.addFigure(new Circle("DUna2", 20));
        shapeCollector.addFigure(new Square("DUna3", 21.02));
        shapeCollector.addFigure(new Triangle("DUna4", 21.02, 10));
        shapeCollector.addFigure(new Triangle("DUna4", 20, 10));
        System.out.println(shapeCollector.getFigures());
        /*// test class SimpleUser
        System.out.println("Test - First unit test of the class SimpleUser");
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // test class Calculator
        System.out.println("Test - First unit test of the class Calculator - add method - should correctly add two integers:");
        Calculator calculator = new Calculator();
        if (calculator.add(1, 2) == 3) {
            System.out.println("test OK");
        } else  {
            System.out.println("Error!");
        }

        System.out.println("Test - Second unit test of the class Calculator - add method - should correctly subtract two integers:");
        if (calculator.subtract(1, 2) == -1) {
            System.out.println("test OK");
        } else  {
            System.out.println("Error!");
        }*/
    }
}
