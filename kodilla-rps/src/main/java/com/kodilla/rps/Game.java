package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    private String humanName;
    private int winnersLimit;
    private String level = "medium";
    private Player humanPlayer;
    private Player computerPlayer;
    Scanner sc = new Scanner(System.in);

    private String chooseLevel() {
        int levelInt = 0;
        do {
            System.out.print("Wybierz poziom: [1 - łatwy], [2 - średni], [3 - trudny] ");
            if (sc.hasNextInt()) {
                levelInt = sc.nextInt();
                if (levelInt < 1 || levelInt > 3) {
                    System.out.println("Wybierz poziom: [1 - łatwy], [2 - średni], [3 - trudny] ");
                }
            } else {
                sc.nextLine();
                System.out.println("Wybierz poziom: [1 - łatwy], [2 - średni], [3 - trudny] ");
            }
        } while (levelInt < 1 || levelInt > 3);

        switch (levelInt) {
            case 1: return "easy";
            case 2: return "medium";
            case 3: return "hard";
        }
        return "";
    }

    private void prepareGame() {

        System.out.println("Nowa gra");
        System.out.print("Jak masz na imię? ");
        humanName = sc.nextLine();
        do {
            System.out.print("Do ilu zwycięstw gramy? ");
            if (sc.hasNextInt()) {
                winnersLimit = sc.nextInt();
                if (winnersLimit <= 0) {
                    System.out.println("Podaj liczbę większą od 0");
                }
            } else {
                sc.nextLine();
                System.out.println("Podaj liczbę większą od 0");
            }
        } while (winnersLimit <= 0);

        level = chooseLevel();

        System.out.println("Witaj, " + humanName + "!");
        System.out.println("Gramy do " + winnersLimit + " zwycięstw.");
        System.out.println("Obsługa gry: ");
        System.out.println("1 - kamień");
        System.out.println("2 - papier");
        System.out.println("3 - nożyce");
        System.out.println("x - zakończenie gry");
        System.out.println("n - rozpoczęcie gry od początku");
    }

    private void createPlayers() {
        humanPlayer = new Player(humanName, 'H');
        computerPlayer = new Player("Komputer", 'C');
    }

    private int runGame() {
        int roundResult;
        int roundNumber = 0;

        while (humanPlayer.getPoints() < winnersLimit && computerPlayer.getPoints() < winnersLimit) {
            roundNumber++;
            Round round = new Round(roundNumber, humanPlayer, computerPlayer, level);
            roundResult = round.play();
            if (roundResult == -1 || roundResult == -2) return roundResult; // end of game or new game
        }
        // somebody gets winnersLimit
        System.out.println("KONIEC GRY");
        if (humanPlayer.getPoints() > computerPlayer.getPoints()) {
            System.out.println("Zwycięzca: " + humanPlayer.getName());
        } else if (humanPlayer.getPoints() < computerPlayer.getPoints()){
            System.out.println("Zwycięzca: " + computerPlayer.getName());
        } else if (humanPlayer.getPoints() == computerPlayer.getPoints()) {
            System.out.println("Remis");
        }
        return 1; // ok - result printed
    }


    public int play() {
        prepareGame();
        createPlayers();
        return runGame(); // returns 1 - ok, result printed, -1 - new game requested, -2 - end of game requested
    }
}
