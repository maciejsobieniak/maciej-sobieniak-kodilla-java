package com.kodilla.stream.sand;

import java.math.BigDecimal;

/**
 * The Europe class implements the SandStorage interface and provides
 * a method to get the quantity of sand beans in Europe.
 */
public class Europe implements SandStorage{

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("12345678901234567890");
        return sandQuantity;
    }
}
