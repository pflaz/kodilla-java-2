package com.kodilla.patterns2.adapter.company.oldhrsystem;

public class Workers {
    private String[][] workers = {
            {"67073040992", "John", "Smith"},
            {"88030405882", "Ivone", "Nowak"},
            {"72030879211", "Jessie", "Pinkman"},
            {"73080900331", "Walter", "White"},
            {"83040566882", "Clara", "Lanson"}
    };
    private double[] salaries = {
            4500.00, 3700.00, 4350.00, 9000.00, 6200.00
    };
    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
