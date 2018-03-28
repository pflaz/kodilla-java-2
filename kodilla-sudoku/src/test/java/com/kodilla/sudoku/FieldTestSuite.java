package com.kodilla.sudoku;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FieldTestSuite {
    @Test
    public void testFieldCopy() {
        // Given
        Field field1 = new Field();
        Field field2 = null;

        // When
        try {
            field2 = field1.copy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        field2.deleteFromPossibleValues(1);

        // Then

        System.out.println("Field1's possible values:");
        field1.getPossibleValues().stream()
                .forEach(System.out::println);

        System.out.println("Field2's possible values:");
        field2.getPossibleValues().stream()
                .forEach(System.out::println);

        Assert.assertEquals(9, field1.getPossibleValues().size());
        Assert.assertEquals(8, field2.getPossibleValues().size());
    }

    @Test
    public void testFieldsComparing() {
        // Given
        Field field1 = new Field();
        field1.setValue(1);

        Field field2 = new Field();
        field2.setValue(1);

        // When & Then
        Assert.assertTrue(field1.equals(field2));

    }

    @Test
    public void testFieldsArraysComparing() {
        // Given


        Field[][] array1 = new Field[2][2];
        Field[][] array2 = new Field[2][2];
        array1[0][0] = new Field();
        array1[1][0] = new Field();
        array2[0][0] = new Field();
        array2[1][0] = new Field();

        array1[0][0].setValue(1);
        array2[0][0].setValue(1);
        array1[1][0].setValue(2);
        array2[1][0].setValue(2);


        // When
        boolean comparison = Arrays.deepEquals(array1, array2);

        // Then
        Assert.assertTrue(comparison);


    }

}