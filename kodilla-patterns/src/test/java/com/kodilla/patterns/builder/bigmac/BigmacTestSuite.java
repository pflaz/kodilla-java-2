package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(Bigmac.ROLL_WITH_SESAME_SEEDS)
                .burgers(5)
                .sauce(Bigmac.SAUCE_1000_ISLANDS)
                .ingredient(Bigmac.LETTUCE)
                .ingredient(Bigmac.BACON)
                .build();

        // When
        System.out.println(bigmac.toString());

        String roll = bigmac.getRoll();
        String sauce = bigmac.getSauce();
        int burgers = bigmac.getBurgers();


        // Then
        Assert.assertTrue(bigmac.getIngredients().contains(Bigmac.LETTUCE));
        Assert.assertTrue(bigmac.getIngredients().contains(Bigmac.BACON));
        Assert.assertEquals(Bigmac.ROLL_WITH_SESAME_SEEDS, roll);
        Assert.assertEquals(Bigmac.SAUCE_1000_ISLANDS, sauce);
        Assert.assertEquals(5, burgers);

    }

}