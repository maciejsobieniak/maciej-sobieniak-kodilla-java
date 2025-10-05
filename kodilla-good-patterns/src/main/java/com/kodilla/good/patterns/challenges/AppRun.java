package com.kodilla.good.patterns.challenges;

public class AppRun {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        MovieStoreService movieStoreService = new MovieStoreService(movieStore);
        if (movieStoreService.printAllMovieTitles() != null) {
            System.out.println(movieStoreService.printAllMovieTitles());
        }

        Calculation factorial = new FactorialCalculation();
        Calculator calculator = new Calculator(factorial);
        InputReceive inputReceive = new ConsoleInputReceive();
        OutputService outputService = new ConsoleOutputService();
        int n = inputReceive.getInt("Enter a number to calculate the factorial: ");
        outputService.print("Factorial of " + n + " = " + calculator.calculate(n));
    }
}
