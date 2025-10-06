package com.kodilla.good.patterns.challenges;

public class ConsoleOutputInformactionService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Dear User: " + user.getUserFullName() + ", your order has been successfully processed.");
    }
}
