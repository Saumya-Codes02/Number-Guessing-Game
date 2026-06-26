package com.saumya.guessinggame.service;

import com.saumya.guessinggame.exception.InvalidInputException;
import com.saumya.guessinggame.game.Difficulty;
import com.saumya.guessinggame.game.Game;
import com.saumya.guessinggame.game.GameStats;
import com.saumya.guessinggame.util.InputHelper;

import java.util.Random;

public class GameService {

    private final Random random = new Random();

    private final InputHelper inputHelper;

    private final GameStats gameStats;

    public GameService(InputHelper inputHelper, GameStats gameStats) {
        this.inputHelper = inputHelper;
        this.gameStats = gameStats;
    }

    public void start() {

        boolean playAgain = true;

        while (playAgain) {

            Difficulty difficulty = chooseDifficulty();

            Game game = createGame(difficulty);

            play(game);

            gameStats.recordGame(game);

            gameStats.displayStats();

            playAgain = askToPlayAgain();
        }

        System.out.println("\nThank you for playing!");
    }

    private Difficulty chooseDifficulty() {

        while (true) {

            System.out.println("\nChoose Difficulty");
            System.out.println("1. " + Difficulty.EASY);
            System.out.println("2. " + Difficulty.MEDIUM);
            System.out.println("3. " + Difficulty.HARD);

            try {

                int choice = inputHelper.readInt("Choice: ");

                return switch (choice) {
                    case 1 -> Difficulty.EASY;
                    case 2 -> Difficulty.MEDIUM;
                    case 3 -> Difficulty.HARD;
                    default -> throw new InvalidInputException("Invalid difficulty.");
                };

            } catch (InvalidInputException e) {

                System.out.println(e.getMessage());

            }
        }
    }

    private Game createGame(Difficulty difficulty) {

        int secret = random.nextInt(
                difficulty.getMaxRange() - difficulty.getMinRange() + 1
        ) + difficulty.getMinRange();

        return new Game(difficulty, secret);
    }

    private void play(Game game) {

        System.out.println("\n========== Game Started ==========");
        System.out.println("Difficulty : " + game.getDifficulty());
        System.out.println("Guess between "
                + game.getDifficulty().getMinRange()
                + " and "
                + game.getDifficulty().getMaxRange());

        while (!game.isGameOver()) {

            try {

                int guess = inputHelper.readInt("\nEnter Guess: ");

                game.validateGuess(guess);

                int result = game.makeGuess(guess);

                if (result == 0) {

                    System.out.println("\n🎉 Congratulations!");
                    System.out.println("You guessed the correct number.");
                    System.out.println("Attempts Used : " + game.getAttempts());

                    return;
                }

                if (result < 0) {
                    System.out.println("⬆ Too Low!");
                } else {
                    System.out.println("⬇ Too High!");
                }

                System.out.println("Remaining Attempts: "
                        + game.getRemainingAttempts());

            }

            catch (InvalidInputException e) {

                System.out.println("❌ " + e.getMessage());

            }

        }

        System.out.println("\n💀 Game Over!");
        System.out.println("The correct number was: "
                + game.getSecretNumber());
    }
    private boolean askToPlayAgain() {

        while (true) {

            String choice =
                    inputHelper.readString("\nPlay Again? (Y/N): ");

            if (choice.equalsIgnoreCase("Y"))
                return true;

            if (choice.equalsIgnoreCase("N"))
                return false;

            System.out.println("Please enter Y or N.");

        }

    }

}