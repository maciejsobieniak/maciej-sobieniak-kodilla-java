package com.kodilla.good.patterns.challenges;

import java.math.BigInteger;

public class FactorialCalculation implements Calculation {
    @Override
    public BigInteger calculate(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
