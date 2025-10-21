package com.kodilla.good.patterns.challenges;

import java.math.BigInteger;

public class FibonacciCalculation implements Calculation {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        BigInteger first = BigInteger.ZERO;
        BigInteger end = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger next = first.add(end);
            first = end;
            end = next;
        }
        return end;
    }
}

