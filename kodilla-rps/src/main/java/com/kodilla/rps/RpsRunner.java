package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) {

        int gameResult;
        boolean end = false;
        Scanner scanner = new Scanner(System.in);
        String input;
        char command = 0;

        System.out.println("Witamy w grze \"Papier, kamień, nożyce\" v.1.1");
        while (!end) {
            Game game = new Game();
            gameResult = game.play();
            if (gameResult == 1) { // previous game finished, result printed
                do {
                    System.out.println("Czy gramy dalej? [N - nowa gra], [X - koniec gry]");
                    if (scanner.hasNext()) {
                        input = scanner.next().toUpperCase();
                        command = input.charAt(0);
                        if (command == 'X') {
                            end = true; // end of game
                        }
                    }
                } while (command != 'N' && command != 'X');
            }
            if (gameResult == -2) {end = true;}

        }
        System.out.println("Dziękujemy za wspólną grę!");
    }
}
