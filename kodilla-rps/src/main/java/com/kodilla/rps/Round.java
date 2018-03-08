package com.kodilla.rps;


public class Round {

    private int number;
    private Player player1;
    private Player player2;
    private Figure figure1;
    private Figure figure2;
    private int result;
    private Translator translator = new Translator();
    private String level = "medium";

    public Round(int number, Player player1, Player player2, String level) {
        this.number = number;
        this.player1 = player1;
        this.player2 = player2;
        this.level = level;
    }

    private void showRoundResult() {
        System.out.println("Wynik rundy " + number);
        System.out.println(player1.getName() + " zagrał: " + translator.translateEnPl(figure1.getName()));
        System.out.println(player2.getName() + " zagrał: " + translator.translateEnPl(figure2.getName()));


        if (result == 1) {
            player1.addPoint();
            System.out.println("Rundę wygrywa: " + player1.getName());
        }
        else if (result == -1) {
            player2.addPoint();
            System.out.println("Rundę wygrywa: " + player2.getName());
        }
        else if (result == 0) {
            System.out.println("Runda zakończona remisem");
        }
        else {
            System.out.println("W trakcie rozgrywki wystąpił błąd.");
        }
        System.out.println("Aktualny wynik: " + player1.getPoints() + ":" + player2.getPoints());
    }

    private Figure getFigure(char symbol) {
        Figure resultFigure = new Figure("");
        if (symbol == '1') {resultFigure = new Figure("Rock");}
        if (symbol == '2') {resultFigure = new Figure("Paper");}
        if (symbol == '3') {resultFigure = new Figure("Scissors");}
        return resultFigure;
    }

    public int play() {
        System.out.println("\nRunda nr " + number);

        char player1Turn = player1.turn();
        char player2Turn = player2.turn();

        // Human
        if (player1Turn == 'X') {return -2;} // end of game
        else if (player1Turn == 'N') {return -1;} // new game
        else {
            figure1 = getFigure(player1Turn); // create figure
        }

        // Computer
        figure2 = getFigure(player2Turn);

        result = figure1.battleWith(figure2);

        if (level.equals("hard") && result == 1) {
            player2Turn = player2.turn();
            figure2 = getFigure(player2Turn);
            result = figure1.battleWith(figure2);
        }

        if (level.equals("easy") && result == -1) {
            player2Turn = player2.turn();
            figure2 = getFigure(player2Turn);
            result = figure1.battleWith(figure2);
        }

        showRoundResult();
        return 1; // OK - result printed
    }
}
