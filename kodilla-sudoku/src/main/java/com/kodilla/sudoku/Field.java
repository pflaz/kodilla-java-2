package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private int value = 0;
    private List<Integer> possibleValues = new ArrayList<>();

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

    public Field() {
        for (int i = 1; i <= 9; i++) {
            possibleValues.add(i);
        }

    }
}
