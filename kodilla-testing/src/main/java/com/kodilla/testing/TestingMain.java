package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {

        // test class SimpleUser
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
        }
    }
}
