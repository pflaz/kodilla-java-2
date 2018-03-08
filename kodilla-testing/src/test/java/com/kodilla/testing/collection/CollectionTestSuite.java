package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("beginning test case");
    }

    @After
    public void after() {
        System.out.println("test case completed");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        ArrayList<Integer> emptyList = new ArrayList<Integer>();
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        //When
        ArrayList<Integer> result = oddNumberExterminator.exterminate(emptyList);
        System.out.println("Testing empty list");
        //Then
        Assert.assertEquals(expectedList, result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        ArrayList<Integer> givenList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            givenList.add(i);
        }

        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        expectedList.add(0);
        expectedList.add(2);
        expectedList.add(4);
        expectedList.add(6);
        expectedList.add(8);

        //When
        ArrayList<Integer> result = oddNumberExterminator.exterminate(givenList);
        System.out.println("Testing normal list");

        //Then
        Assert.assertEquals(expectedList, result);

    }


}
