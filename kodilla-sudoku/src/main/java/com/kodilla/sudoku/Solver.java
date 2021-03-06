package com.kodilla.sudoku;

import com.kodilla.sudoku.exceptions.OutOfRangeException;
import com.kodilla.sudoku.exceptions.WrongNumberOfValuesException;
import com.kodilla.sudoku.exceptions.WrongValuesException;

import java.util.Scanner;
import java.util.Set;

public class Solver {
    private String[] rows = new String[9];
    private Board mainBoard;

    public boolean putValues() {
        System.out.println("Please provide known values to the board (for unknown value, please provide 0).");
        System.out.println("If you want to exit, please provide: EXIT");
        Scanner scanner = new Scanner(System.in);
        boolean rowCorrect = false;
        boolean exit = false;
        for (int row = 0; row < 9; row++) {
            do {
                rowCorrect = false;
                System.out.print("Row number " + (row + 1) + ": ");
                rows[row] = scanner.nextLine();
                if (rows[row].toUpperCase().equals("EXIT")) {
                    exit = true;
                    break;
                }
                try {
                    rowCorrect = checkRowsCorrectness(rows[row]);
                } catch (WrongValuesException e) {
                    System.out.println("Values should be from 0 (unknown value) to 9.");
                } catch (WrongNumberOfValuesException e) {
                    System.out.println("Please provide 9 values");
                }
            } while (!rowCorrect && !exit);
            if (exit) return false;
        }
        System.out.println("Values provided.");
        return true;
    }

    private boolean checkRowsCorrectness(String row) throws WrongNumberOfValuesException, WrongValuesException {
        if (row.length() != 9) {
            throw new WrongNumberOfValuesException();
        }

        for (char value : row.toCharArray()) {
            if (!(Character.getNumericValue(value) >= 0 && Character.getNumericValue(value) <= 9)) {
                throw new WrongValuesException();
            }
        }
        return true;
    }

    public boolean createBoard() {
        Board board = new Board();
        boolean boardCreated;
        try {
            boardCreated = board.setAllValues(rows);
        } catch (WrongNumberOfValuesException | OutOfRangeException e) {
            System.out.println("Error: " + e);
            return false;
        }
        if (!boardCreated) {
            System.out.println("Some of values are not correct. Please try again.");
            return false;
        }
        System.out.println("Board created: ");
        System.out.println(board.toString());
        this.mainBoard = board;
        return true;
    }

    public boolean showSolutions() {
        Set<Board> solutions = null;

        try {
            solutions = mainBoard.solve();
        } catch (Exception e) {
            System.out.println("An error occured.");
            return false;
        }
        System.out.println("Number of solutions: " + solutions.size());
        int solutionCounter = 0;
        for (Board solution : solutions) {
            solutionCounter++;
            System.out.println("\nSolution " + solutionCounter);
            System.out.println(solution.toString());
        }
        System.out.println();

        return true;
    }

    public void showLevel() {
        try {
            int level =  mainBoard.getLevel();
            System.out.println("This sudoku's level is: " + level);
        } catch (Exception e) {
            System.out.println("An error occured.");
        }
    }
}
