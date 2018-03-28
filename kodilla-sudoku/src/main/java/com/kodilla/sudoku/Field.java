package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Field extends Prototype {

    private int value = 0;
    private List<Integer> possibleValues = new ArrayList<>();

    public Field() {
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    protected boolean setValue(int value) {
        if (this.value != 0 || !possibleValues.contains(value)) {
            return false;
        }

        this.value = value;
        return true;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public void deleteFromPossibleValues(int value) {
        possibleValues.remove(Integer.valueOf(value));
    }

    public Field copy() throws CloneNotSupportedException {
        Field clonedField = (Field)super.clone();
        clonedField.possibleValues = new ArrayList<>();
        for (int possibleValue : this.possibleValues) {
            clonedField.possibleValues.add(possibleValue);
        }
        return clonedField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return value == field.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }
}
