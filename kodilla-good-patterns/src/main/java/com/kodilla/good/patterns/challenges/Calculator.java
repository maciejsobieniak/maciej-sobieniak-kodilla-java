package com.kodilla.good.patterns.challenges;

import java.math.BigInteger;

public class Calculator {

    private final Calculation calculation;

    public Calculator(Calculation calculation) {
        this.calculation = calculation;
    }

    public BigInteger calculate(int a) {
        return calculation.calculate(a);
    }


}
