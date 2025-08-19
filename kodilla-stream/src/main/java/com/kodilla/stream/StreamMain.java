package com.kodilla.stream;

import com.kodilla.stream.lambda.SaySomething;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.MathExpression;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        //ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        //processor.execute(executeSaySomething);
        //processor.execute(() -> System.out.println("This is an example text.")); - this is a lambda expression that implements the Executor interface
        Executor codeToExecute = () -> System.out.println("This is an example text.");  // [7]
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();       // [5]

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);           // [6]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);           // [7]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);           // [8]
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautifying text with lambda expressions");
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("This is a beautiful text", (text) -> "ABC " + text + " ABC");
        poemBeautifier.beautify("This is a beautiful text", (text) -> "-<>-" + text + "-<>-");
        poemBeautifier.beautify("This is a beautiful text", (text) -> text.toUpperCase() + "!!!");
        poemBeautifier.beautify("This is a beautiful text", (text) -> text.toLowerCase());

        for (int i = 1; i < 10; i++) {
            poemBeautifier.beautify("*".repeat(i), (text) -> "|"+ text + "|");
        }

        poemBeautifier.beautify("This is a beautiful text", text -> {
            StringBuilder result = new StringBuilder(text);
            return result.reverse().toString();
        });

        poemBeautifier.beautify("This is a beautiful text", text -> {
            String result = "+--------------------------+\n" +
                            "| " + text + " |\n" +
                            "+--------------------------+";
            return result;
        });

        poemBeautifier.beautify("This is a beautiful text", text -> {
            String result = "";
            for (int i = 0; i < text.length(); i++) {
                if (i % 2 == 0) {
                    result += Character.toUpperCase(text.charAt(i));
                } else {
                    result += Character.toLowerCase(text.charAt(i));
                }
            }
            return result;
        });

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
