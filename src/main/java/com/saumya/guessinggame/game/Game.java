package com.saumya.guessinggame.game;

import com.saumya.guessinggame.exception.InvalidInputException;

/**
 * Represents a single game session.
 */
public class Game {

    private final Difficulty difficulty;
    private final int secretNumber;

    private int attempts;
    private boolean won;

    public Game(Difficulty difficulty, int secretNumber) {
        this.difficulty = difficulty;
        this.secretNumber = secretNumber;
        this.attempts = 0;
        this.won = false;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getAttempts() {
        return attempts;
    }

    public boolean isWon() {
        return won;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public int getRemainingAttempts() {
        return difficulty.getMaxAttempts() - attempts;
    }

    public boolean isGameOver() {
        return won || attempts >= difficulty.getMaxAttempts();
    }

    /**
     * Validates whether the guess is inside the allowed range.
     */
    public void validateGuess(int guess) {

        if (guess < difficulty.getMinRange() ||
                guess > difficulty.getMaxRange()) {

            throw new InvalidInputException(
                    "Guess must be between "
                            + difficulty.getMinRange()
                            + " and "
                            + difficulty.getMaxRange()
            );
        }
    }

    /**
     * Checks the player's guess.
     *
     * @return
     * -1 = Too Low
     *  0 = Correct
     *  1 = Too High
     */
    public int makeGuess(int guess) {

        attempts++;

        if (guess == secretNumber) {
            won = true;
            return 0;
        }

        return guess < secretNumber ? -1 : 1;
    }
}