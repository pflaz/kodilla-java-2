package com.kodilla.sudoku;

public class Sudoku {

    public static void main(String[] args) {
        boolean valuesProvided;
        boolean boardCreated;
        System.out.println("Welcome to the Sudoku Solver.");
        do {
            Solver solver = new Solver();
            valuesProvided = solver.putValues();
            if (!valuesProvided) break;
            boardCreated = solver.createBoard();
            if (boardCreated) {
                solver.showSolutions();
                solver.showLevel();
            }
            System.out.println();
        } while (valuesProvided);
        System.out.println("Thank you, bye!");

    }
}
