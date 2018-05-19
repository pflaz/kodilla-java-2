package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetPrice() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();

        // When
        BigDecimal price = pizzaOrder.getPrice();

        // Then
        assertEquals(new BigDecimal(15), price);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("cheese + tomato sauce", description);
    }

    @Test
    public void testPizzaWithMushroomsGetPrice() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        BigDecimal price = pizzaOrder.getPrice();

        // Then
        assertEquals(new BigDecimal(18), price);
    }

    @Test
    public void testPizzaWithMushroomsGeDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("cheese + tomato sauce + mushrooms", description);
    }

    @Test
    public void testPizzaWithMushroomsAndHamWithExtraCheeseGetPrice() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        // When
        BigDecimal price = pizzaOrder.getPrice();

        // Then
        assertEquals(new BigDecimal(24), price);
    }

    @Test
    public void testPizzaWithMushroomsAndHamWithExtraCheeseGetDescription() {
        // Given
        PizzaOrder pizzaOrder = new BasicPizzaOrderDecorator();
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        // When
        String description = pizzaOrder.getDescription();

        // Then
        assertEquals("cheese + tomato sauce + mushrooms + ham + extra cheese", description);
    }

}