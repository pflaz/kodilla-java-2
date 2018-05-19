package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        Assert.assertEquals(new BigDecimal(5.00), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        // When
        String retrievedDescription = theOrder.getDescription();

        // Then
        Assert.assertEquals("Drive a course", retrievedDescription);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        Assert.assertEquals(new BigDecimal(40.00), calculatedCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        // When
        String retrievedDescription = theOrder.getDescription();

        // Then
        Assert.assertEquals("Drive a course by Taxi Network", retrievedDescription);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        Assert.assertEquals(new BigDecimal(37.00), calculatedCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        String retrievedDescription = theOrder.getDescription();

        // Then
        Assert.assertEquals("Drive a course by MyTaxi Network + child seat", retrievedDescription);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        Assert.assertEquals(new BigDecimal(29.00), calculatedCost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);

        // When
        String retrievedDescription = theOrder.getDescription();

        // Then
        Assert.assertEquals("Drive a course by Uber Network + child seat + child seat", retrievedDescription);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);

        // When
        BigDecimal calculatedCost = theOrder.getCost();

        // Then
        Assert.assertEquals(new BigDecimal(57.00), calculatedCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ExpressDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);

        // When
        String retrievedDescription = theOrder.getDescription();

        // Then
        Assert.assertEquals("Drive a course by Taxi Network + child seat express service variant VIP", retrievedDescription);
    }

}