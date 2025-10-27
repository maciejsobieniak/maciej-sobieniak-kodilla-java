package com.kodilla.good.patterns.challenges;

public class FibonacciRecursiveCalculation {

    public static int calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        return calculate(n - 1) + calculate(n - 2);
    }
}
