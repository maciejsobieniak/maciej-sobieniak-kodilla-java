package com.kodilla.good.patterns.challenges;

import java.util.Scanner;

public class ConsoleInputReceive implements InputReceive {
    @Override
    public int getInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        while (true) {
            String inputString = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(inputString);
                return value;

            } catch (NumberFormatException e) {
                System.out.println("This is not a number. Please select a number. ");
            }
        }
    }
}

