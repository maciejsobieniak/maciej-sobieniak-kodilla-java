package com.kodilla.stream.sand;

import java.math.BigDecimal;

/**
 * The Asia class implements the SandStorage interface and provides
 * a method to get the quantity of sand beans in Asia.
 */
public final class Asia implements SandStorage {

    @Override
    public BigDecimal getSandBeansQuantity() {
        BigDecimal sandQuantity = new BigDecimal("98765432101234567890");
        return sandQuantity;
    }
}
