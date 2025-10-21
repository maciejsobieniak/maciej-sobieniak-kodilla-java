package com.kodilla.good.patterns.challenges;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciCalculationTest {
    @Test
    void testFibonacciZeroNumber() {
        FibonacciCalculation fib = new FibonacciCalculation();
        assertEquals(BigInteger.ZERO, fib.calculate(0));
    }

    @Test
    void testFibonacciOneNumber() {
        FibonacciCalculation fib = new FibonacciCalculation();
        assertEquals(BigInteger.ONE, fib.calculate(1));
    }

    @Test
    void testFibonacciRandomNumbers() {
        FibonacciCalculation fib = new FibonacciCalculation();
        assertEquals(BigInteger.ONE, fib.calculate(2));
        assertEquals(BigInteger.valueOf(5), fib.calculate(5));
        assertEquals(BigInteger.valueOf(55), fib.calculate(10));
    }

    @Test
    void testFibonacciNegativeNumber() {
        FibonacciCalculation fib = new FibonacciCalculation();
        assertThrows(IllegalArgumentException.class, () -> fib.calculate(-1));
    }
}

