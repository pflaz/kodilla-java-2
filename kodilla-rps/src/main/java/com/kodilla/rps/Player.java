package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Player {
    private final String name;
    private int points = 0;
    private final char type; // 'H' - human, 'C' - computer

    public Player(String name, char type) {
        this.name = name;
        this.type = type;
    }

    public void addPoint() {
        points++;
    }

    public char turn() {
        Scanner scanner = new Scanner(System.in);
        String input;
        char command;
        char internalCommand;
        int drawnNumber;
        Random random = new Random();

        if (type == 'H') {
            do {
                System.out.print(name + ", Twój ruch: ");
                if (scanner.hasNext()) {
                    input = scanner.next().toUpperCase();
                    command = input.charAt(0);
                    if (command == '1' || command == '2' || command == '3') {
                        return command;
                    } else if (command == 'N') {
                        System.out.print("Czy na pewno rozpocząć grę od początku? [T/N]");
                        input = scanner.next().toUpperCase();
                        internalCommand = input.charAt(0);
                        if (internalCommand == 'T') return 'N';
                    } else if (command == 'X') {
                        System.out.print("Czy na pewno zakończyć grę? [T/N]");
                        input = scanner.next().toUpperCase();
                        internalCommand = input.charAt(0);
                        if (internalCommand == 'T') return 'X';
                    } else {
                        scanner.nextLine();
                        System.out.println("Wybierz opcję: <1> kamień, <2> papier, <3> nożyce, <x> zakończenie gry, <n> nowa gra");
                    }
                }
            } while (true);

        } else if (type == 'C') {
            drawnNumber = random.nextInt(3) + 1;
            return Character.forDigit(drawnNumber, 10);
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public int getPoints() {
        return points;
    }
}
