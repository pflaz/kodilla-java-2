package com.kodilla.rps;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RpsTestSuite {

    @Test
    public void testCreatePlayer() {
        //Given
        Player player1 = new Player("testplayer", 'H');

        // When

        // Then
        Assert.assertEquals("testplayer", player1.getName());
        Assert.assertEquals('H', player1.getType());
        Assert.assertEquals(0, player1.getPoints());
    }

    @Test
    public void testAddingPoints() {
        //Given
        Player player1 = new Player("testplayer", 'H');

        // When
        player1.addPoint();

        // Then
        Assert.assertEquals(1, player1.getPoints());
    }

    @Test
    public void testDrawNumberByComputerPlayer() {
        // Given
        Player computerPlayer = new Player("computer", 'C');
        List<Character> drawnNumbers = new ArrayList<>();
        List<Character> okNumbers = new ArrayList<>();
        okNumbers.add('1');
        okNumbers.add('2');
        okNumbers.add('3');

        // When
        for (int i = 0; i < 100; i++) {
            drawnNumbers.add(computerPlayer.turn());
        }
        long drawnOkNumber = drawnNumbers.stream()
                .filter(number -> okNumbers.contains(number))
                .count();

        // Then
        Assert.assertEquals(drawnNumbers.size(), drawnOkNumber);
    }

    @Test
    public void testBattleTheSameFigure() {
        // Given
        Figure figure1 = new Figure("Rock");
        Figure figure2 = new Figure("Rock");
        Figure figure3 = new Figure("Paper");
        Figure figure4 = new Figure("Paper");
        Figure figure5 = new Figure("Scissors");
        Figure figure6 = new Figure("Scissors");

        // When
        int result1 = figure1.battleWith(figure2);
        int result2 = figure2.battleWith(figure1);
        int result3 = figure3.battleWith(figure4);
        int result4 = figure4.battleWith(figure3);
        int result5 = figure5.battleWith(figure6);
        int result6 = figure6.battleWith(figure5);

        // Then
        Assert.assertEquals(0, result1);
        Assert.assertEquals(0, result2);
        Assert.assertEquals(0, result3);
        Assert.assertEquals(0, result4);
        Assert.assertEquals(0, result5);
        Assert.assertEquals(0, result6);
    }

    @Test
    public void testBattleRockAndPaper() {
        // Given
        Figure figure1 = new Figure("Rock");
        Figure figure2 = new Figure("Paper");

        // When
        int result1 = figure1.battleWith(figure2);
        int result2 = figure2.battleWith(figure1);

        // Then
        Assert.assertEquals(-1, result1);
        Assert.assertEquals(1, result2);
    }

    @Test
    public void testBattleRockAndScissors() {
        // Given
        Figure figure1 = new Figure("Rock");
        Figure figure2 = new Figure("Scissors");

        // When
        int result1 = figure1.battleWith(figure2);
        int result2 = figure2.battleWith(figure1);

        // Then
        Assert.assertEquals(1, result1);
        Assert.assertEquals(-1, result2);
    }

    @Test
    public void testBattlePaperAndScissors() {
        // Given
        Figure figure1 = new Figure("Paper");
        Figure figure2 = new Figure("Scissors");

        // When
        int result1 = figure1.battleWith(figure2);
        int result2 = figure2.battleWith(figure1);

        // Then
        Assert.assertEquals(-1, result1);
        Assert.assertEquals(1, result2);
    }
}
