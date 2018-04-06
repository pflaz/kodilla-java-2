package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.OutOfRangeException;
import com.kodilla.sudoku.exceptions.WrongNumberOfValuesException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class BoardTestSuite {

    @Test
    public void testCreatingEmptyBoard() {
        // Given
        Board board = new Board();

        // When
        System.out.println(board.toString());
        int numberOfColumns = board.getFields().length;

        // Then
        Assert.assertEquals(9, numberOfColumns);
    }

    @Test
    public void testFillingTheSameField() {
        // Given
        Board board = new Board();

        // When
        boolean result1 = false;
        boolean result2 = false;
        try {
            result1 = board.setFieldsValue(1, 8, 5);
            result2 = board.setFieldsValue(1, 8, 6);
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }

        // Then
        System.out.println(board.toString());

        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
        Assert.assertEquals(5, board.getFields()[1][8].getValue());
    }

    @Test
    public void testFillingDuplicateInRow() {
        // Given
        Board board = new Board();

        // When
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        try {
            result1 = board.setFieldsValue(1, 8, 5);
            result2 = board.setFieldsValue(3, 8, 6);
            result3 = board.setFieldsValue(6, 8, 5);
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }


        // Then
        System.out.println(board.toString());

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertEquals(5, board.getFields()[1][8].getValue());
        Assert.assertEquals(6, board.getFields()[3][8].getValue());
        Assert.assertEquals(0, board.getFields()[6][8].getValue());
    }

    @Test
    public void testFillingDuplicateInColumn() {
        // Given
        Board board = new Board();

        // When
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        try {
            result1 = board.setFieldsValue(1, 8, 5);
            result2 = board.setFieldsValue(1, 6, 6);
            result3 = board.setFieldsValue(1, 1, 5);
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }

        // Then
        System.out.println(board.toString());

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertEquals(5, board.getFields()[1][8].getValue());
        Assert.assertEquals(6, board.getFields()[1][6].getValue());
        Assert.assertEquals(0, board.getFields()[1][1].getValue());
    }

    @Test
    public void testFillingDuplicateInBlock() {
        // Given
        Board board = new Board();

        // When
        boolean result1 = false;
        boolean result2 = false;
        boolean result3 = false;
        try {
            result1 = board.setFieldsValue(3, 3, 5);
            result2 = board.setFieldsValue(4, 4, 6);
            result3 = board.setFieldsValue(5, 5, 5);
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }


        // Then
        System.out.println(board.toString());

        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
        Assert.assertEquals(5, board.getFields()[3][3].getValue());
        Assert.assertEquals(6, board.getFields()[4][4].getValue());
        Assert.assertEquals(0, board.getFields()[5][5].getValue());
    }

    @Test
    public void testSetRowValues() {
        // Given
        Board board = new Board();

        // When
        String values = "123456780";
        boolean result = false;
        try {
            result = board.setRowsValues(1, values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        // Then
        Assert.assertTrue(result);
        System.out.println(board.toString());
    }

    @Test
    public void testSetAllValues() {
        // Given
        Board board = new Board();
        String[] values = {"974281356", "638594271", "512736984",
                "459823167", "381967425", "726145893",
                "843679512", "197452638", "265318749"};

        // When
        boolean result = false;
        try {
            result = board.setAllValues(values);
        } catch (WrongNumberOfValuesException | OutOfRangeException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(board.toString());
        Assert.assertTrue(result);

    }

    @Test
    public void testFillEvidentValues() {
        // Given
        Board board = new Board();

        // When
        String values = "123456700";
        try {
            board.setRowsValues(1, values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        int filled = 0;
        try {
            filled = board.fillEvidentValuesOnce();
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }

        // Then
        Assert.assertEquals(0, filled);
        System.out.println(board.toString());
    }

    @Test
    public void testSolveByFillingEvidentValues() {
        // Given
        Board board = new Board();
        String[] values = {"970200006", "008000201", "012700980",
                "000020107", "000967000", "706040000",
                "043009510", "107000600", "200008049"};

        // When
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        int filled = 0;
        try {
            filled = board.fillAllEvidentValues();
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }

        // Then
        System.out.println("filled: " + filled);
        System.out.println(board.toString());
    }

    @Test
    public void testSolveByFillingEvidentValues2() {
        // Given
        Board board = new Board();
        String[] values = {"060430028", "000918030", "004020000",
                "090000302", "306090507", "201000080",
                "000080100", "010254000", "980067040"};

        // When
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        int filled = 0;
        try {
            filled = board.fillAllEvidentValues();
        } catch (OutOfRangeException e) {
            System.out.println(e);
        }

        // Then
        System.out.println("filled: " + filled);
        System.out.println(board.toString());
    }

    @Test
    public void testIsSolved() {
        // Given
        Board board = new Board();
        String[] values = {"974281356", "638594271", "512736984",
                "459823167", "381967425", "726145893",
                "843679512", "197452638", "265318749"};

        // When
        try {
            board.setAllValues(values);
        } catch (WrongNumberOfValuesException | OutOfRangeException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(board.toString());
        Assert.assertTrue(board.isSolved());

    }

    @Test
    public void testFindMinimumPossibleValues() {
        // Given
        Board board = new Board();
        String[] values = {"000000000", "034702500", "002409008",
                "396147285", "050826043", "028090600",
                "080951400", "240638059", "005274830"};
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        // When
        ColumnRowDto columnRowDto = new ColumnRowDto(-1, -1);

        try {
            columnRowDto = board.findFieldWithMinimumPossibleValues();
        } catch (Exception e) {
            System.out.println(e);
        }
        int min = board.getFields()[columnRowDto.getColumn()][columnRowDto.getRow()].getPossibleValues().size();

        // Then
        System.out.println("field with minimum possible values: " + columnRowDto.getColumn() + ", " + columnRowDto.getRow());
        System.out.println("min: " + min);
    }

    @Test
    public void testCopyBoard() {
        // Given
        Board board = new Board();
        String[] values = {"004093100", "030400050", "800017003",
                "609000080", "508030701", "010000902",
                "900160007", "070002010", "002370800"};
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        // When
        Board copiedBoard = new Board();
        try {
            copiedBoard = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        try {
            copiedBoard.setFieldsValue(0, 0, 2);
        } catch (Exception e) {
            System.out.println(e);
        }

        //Then

        System.out.println("Original board:");
        System.out.println(board.toString());
        System.out.println();
        System.out.println("Coppied board:");
        System.out.println(copiedBoard.toString());

        Assert.assertEquals(0, board.getFields()[0][0].getValue());
        Assert.assertEquals(2, board.getFields()[0][0].getPossibleValues().size());
        Assert.assertEquals(2, copiedBoard.getFields()[0][0].getValue());
        Assert.assertTrue(board.getFields()[1][0].getPossibleValues().contains(2));
        Assert.assertFalse(copiedBoard.getFields()[1][0].getPossibleValues().contains(2));
    }


    @Test
    public void testSolving() {

        // Given
        Board board = new Board();
        String[] values = {"096050730", "000000060", "500607008",
                "002706380", "080005010", "004803970",
                "200501007", "000000000", "069070450"};
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        Set<Board> solutions = null;

        // When
        try {
           solutions = board.solve();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Then
        System.out.println("Number of solutions: " + solutions.size());
        int solutionCounter = 0;

        for (Board solution : solutions) {
            solutionCounter++;

            System.out.println("\nSolution " + solutionCounter);
            System.out.println(solution.toString());
        }
        Assert.assertEquals(1, solutions.size());
    }

    @Test
    public void testLevelGetting() {

        // Given
        Board board = new Board();
        String[] values = {"529741836", "786539412", "314286579",
                "295473168", "163892754", "847165923",
                "458327691", "972614385", "000000000"};
        try {
            board.setAllValues(values);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        int level = 0;
        // When
        try {
            level = board.getLevel();
        } catch (Exception e) {
            System.out.println(e);
        }

        // Then

        Assert.assertEquals(1, level);
    }


    @Test
    public void testBoardsEqualing() {
        // Given

        String[] values = {"004093100", "030400050", "800017003",
                "609000080", "508030701", "010000902",
                "900160007", "070002010", "002370800"};
        String[] blankValues = {"000000000", "000000000", "000000000",
                "000000000", "000000000", "000000000",
                "000000000", "000000000", "000000000"};

        Board board1 = new Board();
        Board board2 = new Board();
        Board board3 = new Board();
        try {
            board1.setAllValues(values);
            board2.setAllValues(values);
            board3.setAllValues(blankValues);
        } catch (OutOfRangeException | WrongNumberOfValuesException e) {
            System.out.println(e);
        }

        // When

        boolean comparison1to2 = board1.equals(board2);
        boolean comparison2to1 = board2.equals(board1);
        boolean comparison1to3 = board1.equals(board3);

        // Then

        Assert.assertTrue(comparison1to2);
        Assert.assertTrue(comparison2to1);
        Assert.assertFalse(comparison1to3);

    }
}