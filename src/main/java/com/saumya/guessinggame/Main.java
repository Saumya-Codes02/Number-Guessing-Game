package com.saumya.guessinggame;

import com.saumya.guessinggame.game.GameStats;
import com.saumya.guessinggame.service.GameService;
import com.saumya.guessinggame.util.InputHelper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputHelper inputHelper =
                new InputHelper(scanner);

        GameStats stats =
                new GameStats();

        GameService gameService =
                new GameService(inputHelper, stats);

        gameService.start();

        scanner.close();

    }

}