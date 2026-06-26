package com.saumya.guessinggame.game;

public enum Difficulty {

    EASY(1, 10, 5),
    MEDIUM(1, 100, 10),
    HARD(1, 1000, 15);

    private final int minRange;
    private final int maxRange;
    private final int maxAttempts;

    Difficulty(int minRange, int maxRange, int maxAttempts) {
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.maxAttempts = maxAttempts;
    }

    public int getMinRange() {
        return minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    @Override
    public String toString() {
        return switch (this) {
            case EASY -> "Easy (1 - 10)";
            case MEDIUM -> "Medium (1 - 100)";
            case HARD -> "Hard (1 - 1000)";
        };
    }
}