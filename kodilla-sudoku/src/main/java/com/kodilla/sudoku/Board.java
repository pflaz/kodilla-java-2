package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.OutOfRangeException;
import com.kodilla.sudoku.exceptions.SolvedBoardException;
import com.kodilla.sudoku.exceptions.UnsolvableBoardException;
import com.kodilla.sudoku.exceptions.WrongNumberOfValuesException;

import java.util.ArrayList;
import java.util.List;

public class Board extends Prototype {
    private Field[][] fields = new Field[9][9];

    public Board() {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                fields[column][row] = new Field();
            }
        }
    }

    private boolean checkValuePresenceInRow(int value, int row) {
        for (int column = 0; column < 9; column++) {
            if (fields[column][row].getValue() == value) return true;
        }
        return false;
    }

    private boolean checkValuePresenceInColumn(int value, int column) {
        for (int row = 0; row < 9; row++) {
            if (fields[column][row].getValue() == value) return true;
        }
        return false;
    }

    private boolean checkValuePresenceInBlock(int value, int block) throws OutOfRangeException {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (getBlock(column, row) == block) {
                    if (fields[column][row].getValue() == value) return true;
                }
            }
        }
        return false;
    }

    private void setAsImpossibleInRow(int row, int value) {
        for (int column = 0; column < 9; column++) {
            fields[column][row].deleteFromPossibleValues(value);
        }
    }

    private void setAsImpossibleInColumn(int column, int value) {
        for (int row = 0; row < 9; row++) {
            fields[column][row].deleteFromPossibleValues(value);
        }
    }

    private void setAsImpossibleInBlock(int block, int value) throws OutOfRangeException {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (getBlock(column, row) == block) {
                    fields[column][row].deleteFromPossibleValues(value);
                }
            }

        }
    }

    private int getBlock(int column, int row) throws OutOfRangeException {
        if (column >= 0 && column <= 2 && row >= 0 && row <= 2) return 1;
        if (column >= 3 && column <= 5 && row >= 0 && row <= 2) return 2;
        if (column >= 6 && column <= 8 && row >= 0 && row <= 2) return 3;
        if (column >= 0 && column <= 2 && row >= 3 && row <= 5) return 4;
        if (column >= 3 && column <= 5 && row >= 3 && row <= 5) return 5;
        if (column >= 6 && column <= 8 && row >= 3 && row <= 5) return 6;
        if (column >= 0 && column <= 2 && row >= 6 && row <= 8) return 7;
        if (column >= 3 && column <= 5 && row >= 6 && row <= 8) return 8;
        if (column >= 6 && column <= 8 && row >= 6 && row <= 8) return 9;
        throw new OutOfRangeException();

    }

    public boolean setFieldsValue(int column, int row, int value) throws OutOfRangeException {

        if (column < 0 || column > 8 || row < 0 || row > 8 || value < 1 || value > 9) {
            throw new OutOfRangeException();
        }
        if (checkValuePresenceInRow(value, row) ||
                checkValuePresenceInColumn(value, column) ||
                checkValuePresenceInBlock(value, getBlock(column, row))) {
            return false;
        }

        boolean result =  fields[column][row].setValue(value);

        if (result) {
            setAsImpossibleInRow(row, value);
            setAsImpossibleInColumn(column, value);
            setAsImpossibleInBlock(getBlock(column, row), value);
        }
        return result;
    }

    public boolean setRowsValues(int row, String values) throws WrongNumberOfValuesException, OutOfRangeException {
        if (values.length() != 9) throw new WrongNumberOfValuesException();

        boolean result;
        for (int column = 0; column < 9; column++) {
            if (Character.getNumericValue(values.charAt(column)) == 0) continue;
            if (!setFieldsValue(column, row, Character.getNumericValue(values.charAt(column)))) {
                return false;
            }
        }
        return true;
    }

    public boolean setAllValues(String[] values) throws WrongNumberOfValuesException, OutOfRangeException {
        if (values.length != 9) throw new WrongNumberOfValuesException();

        boolean result;
        for (int row = 0; row < 9; row ++) {
            if (!setRowsValues(row, values[row])) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String currentValue;
        StringBuilder result = new StringBuilder();
        result.append("-------------------------------------\n");
        for (int row = 0; row <= 8; row++) {
            for (int column = 0; column <= 8; column++) {
                currentValue = String.valueOf(fields[column][row].getValue());
                if (currentValue.equals("0")) {currentValue = " ";}
                result.append("| " + currentValue + " ");
            }
            result.append("|\n-------------------------------------\n");
        }
        return result.toString();
    }

    public Field[][] getFields() {
        return fields;
    }

    public int fillEvidentValuesOnce() throws OutOfRangeException {
        int filled = 0;

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (fields[column][row].getValue() == 0 && fields[column][row].getPossibleValues().size() == 1) {
                    setFieldsValue(column, row, fields[column][row].getPossibleValues().get(0));
                    filled++;
                }
            }
        }
        return filled;
    }

    public boolean isSolved() {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (fields[column][row].getValue() == 0) return false;
            }
        }
        return true;
    }

    public boolean isUnsolvable() {
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (fields[column][row].getValue() == 0 && fields[column][row].getPossibleValues().size() == 0) return true;
            }
        }
        return false;
    }

    public int fillAllEvidentValues() throws OutOfRangeException {
        if (isUnsolvable()) return 0;
        if (isSolved()) return 0;

        int sumOfFilledEvidentValues = 0;
        int filledEvidentValues;
        do {
            filledEvidentValues = fillEvidentValuesOnce();
            sumOfFilledEvidentValues += filledEvidentValues;
        } while (filledEvidentValues > 0);

        return sumOfFilledEvidentValues;
    }

    public ColumnRowDto findFieldWithMinimumPossibleValues() throws UnsolvableBoardException, SolvedBoardException, Exception {
        if (isUnsolvable()) throw new UnsolvableBoardException();
        if (isSolved()) throw new SolvedBoardException();
        int min = 0;
        ColumnRowDto columnRowDto = new ColumnRowDto(-1, -1);
        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (fields[column][row].getValue() == 0) {
                    if (min == 0 || fields[column][row].getPossibleValues().size() < min) {
                        min = fields[column][row].getPossibleValues().size();
                        columnRowDto.setColumn(column);
                        columnRowDto.setRow(row);
                    }
                }
            }
        }
        if (columnRowDto.getColumn() == -1 || columnRowDto.getRow() == -1) throw new Exception();
        return columnRowDto;
    }

    public List<Board> solve() throws OutOfRangeException {
        List<Board> solutions = new ArrayList<>();

        fillAllEvidentValues();
        if (isSolved()) {
            solutions.add(this);
        }
        if (isUnsolvable()) return null;

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                if (fields[column][row].getValue() == 0 && fields[column][row].getPossibleValues().size() > 0) {
                    for (int possibleValue : fields[column][row].getPossibleValues()) {

                    }
                }
            }
        }

        return solutions;
    }

    public Board copy() throws CloneNotSupportedException {
        Board result;
        result = (Board)super.clone();

        return result;
    }




}
