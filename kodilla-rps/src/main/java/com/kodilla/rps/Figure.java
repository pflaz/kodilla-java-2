package com.kodilla.rps;

import java.util.Objects;

public class Figure {
    private String name; // Rock, Paper, Scissors

    public Figure(String name) {
        this.name = name;
    }

    public int battleWith(Figure figure) { // 1 - this is winner, -1 - this losts, 0 - draw, -2 - error
        if (this.equals(figure)) return 0;
        if (this.name.equals("Rock") && figure.getName().equals("Scissors")) return 1;
        if (this.name.equals("Rock") && figure.getName().equals("Paper")) return -1;
        if (this.name.equals("Scissors") && figure.getName().equals("Rock")) return -1;
        if (this.name.equals("Scissors") && figure.getName().equals("Paper")) return 1;
        if (this.name.equals("Paper") && figure.getName().equals("Scissors")) return -1;
        if (this.name.equals("Paper") && figure.getName().equals("Rock")) return 1;
        return -2;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(name, figure.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
