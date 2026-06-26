package com.saumya.guessinggame.game;

/**
 * Stores statistics across multiple games.
 */
public class GameStats {

    private int gamesPlayed;
    private int gamesWon;
    private int totalAttempts;
    private int bestScore = Integer.MAX_VALUE;

    public void recordGame(Game game) {

        gamesPlayed++;
        totalAttempts += game.getAttempts();

        if (game.isWon()) {

            gamesWon++;

            if (game.getAttempts() < bestScore) {
                bestScore = game.getAttempts();
            }
        }
    }

    public void displayStats() {

        System.out.println("\n========== Statistics ==========");
        System.out.println("Games Played : " + gamesPlayed);
        System.out.println("Games Won    : " + gamesWon);
        System.out.println("Games Lost   : " + (gamesPlayed - gamesWon));

        if (gamesWon > 0) {
            System.out.println("Best Score   : " + bestScore + " attempts");
        }

        double average =
                gamesPlayed == 0
                        ? 0
                        : (double) totalAttempts / gamesPlayed;

        System.out.printf("Average Attempts : %.2f%n", average);

        double winRate =
                gamesPlayed == 0
                        ? 0
                        : ((double) gamesWon / gamesPlayed) * 100;

        System.out.printf("Win Rate : %.2f%%%n", winRate);

        System.out.println("===============================");
    }
}