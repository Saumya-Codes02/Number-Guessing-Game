package com.saumya.guessinggame.util;

import com.saumya.guessinggame.exception.InvalidInputException;

import java.util.Scanner;

/**
 * Utility class for reading validated user input.
 */
public class InputHelper {

    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message) {

        System.out.print(message);

        if (!scanner.hasNextInt()) {
            scanner.next();
            throw new InvalidInputException("Please enter a valid integer.");
        }

        return scanner.nextInt();
    }

    public String readString(String message) {

        System.out.print(message);
        return scanner.next();
    }
}