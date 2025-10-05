package com.kodilla.good.patterns.challenges;

public class appRun {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        MovieStoreService movieStoreService = new MovieStoreService(movieStore);
        if ( movieStoreService.printAllMovieTitles() != null) {
            System.out.println( movieStoreService.printAllMovieTitles());
        }
    }
}
