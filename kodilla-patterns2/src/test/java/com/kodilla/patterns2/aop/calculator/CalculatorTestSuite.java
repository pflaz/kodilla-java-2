package com.kodilla.patterns2.aop.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Test
    public void testAdd() {
        // Given

        // When
        double result = calculator.add(4, 5);

        // Then
        LOGGER.info("Testing add method");
        assertEquals(9, result, 0);
    }

    @Test
    public void testSub() {
        // Given

        // When
        double result = calculator.sub(4, 5);

        // Then
        LOGGER.info("Testing sub method");
        assertEquals(-1, result, 0);
    }

    @Test
    public void testMul() {
        // Given

        // When
        double result = calculator.mul(4, 5);

        // Then
        LOGGER.info("Testing mul method");
        assertEquals(20, result, 0);
    }

    @Test
    public void testDiv() {
        // Given

        // When
        double result = calculator.div(4, 5);

        // Then
        LOGGER.info("Testing div method");
        assertEquals(0.8, result, 0);
    }

    @Test
    public void testFactorial() {
        // Given

        // When
        BigDecimal result = calculator.factorial(new BigDecimal(4));
        BigDecimal result2 = calculator.factorial(new BigDecimal(1000));

        //Then
        LOGGER.info("Testing factorial method");
        assertEquals(new BigDecimal(24), result);
        assertTrue(BigDecimal.ONE.compareTo(result2) < 0);
    }



}