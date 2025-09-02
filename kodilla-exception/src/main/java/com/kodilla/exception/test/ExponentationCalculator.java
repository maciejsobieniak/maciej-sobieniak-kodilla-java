package com.kodilla.exception.test;

/*
    Class ExponentationCalculator includes method exponentation(int a, int b) which calculates a^b (a to the power of b)
    using recursion. The method throws IllegalArgumentException when one of the parameters is negative.
    The method handles the following special cases:
    - 0^0 is defined as 1
    - a^0 is defined as 1 for any non-negative a
    - 0^b is defined as 0 for any positive b
    - a^1 is defined as a for any non-negative a
*/
public class ExponentationCalculator {

    public int exponentation(int a, int b) {

        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Both numbers must be non-negative.");
        }

        if (a == 0 && b == 0) {
            return 1; // 0^0 is often defined as 1
        }

        if (a == 0) {
            return 0;
        }

        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a;
        }

        return a * exponentation(a, b - 1);
    }


    public static void main(String[] args) {
        ExponentationCalculator calculator = new ExponentationCalculator();

        try {
            System.out.println("3^4 = " + calculator.exponentation(3, 4)); // 81
            System.out.println("2^5 = " + calculator.exponentation(2, 5)); // 32
            System.out.println("0^0 = " + calculator.exponentation(0, 0)); // 1
            System.out.println("5^0 = " + calculator.exponentation(5, 0)); // 1
            System.out.println("0^3 = " + calculator.exponentation(0, 3)); // 0
            System.out.println("4^1 = " + calculator.exponentation(4, 1)); // 4
           // System.out.println("2^-3 = " + calculator.exponentation(2, -3)); // Exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("End of calculations.");
        }
    }
}
