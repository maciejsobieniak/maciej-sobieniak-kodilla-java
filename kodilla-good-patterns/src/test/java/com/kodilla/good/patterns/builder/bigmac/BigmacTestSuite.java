package com.kodilla.good.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SESAME)
                .burgers(2)
                .sauce(Sauce.STANDARD)
                .ingredient(Ingredient.LETTUCE)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.ONION)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CHILLI)
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        assertEquals(5, howManyIngredients);
        assertEquals(Bun.WITH_SESAME, bigmac.getBun());
        assertEquals(Sauce.STANDARD, bigmac.getSauce());
        assertEquals(2, bigmac.getBurgers());
    }
}
