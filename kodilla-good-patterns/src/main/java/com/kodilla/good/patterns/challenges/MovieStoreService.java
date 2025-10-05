package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStoreService {

    private MovieStore movieStore;

    public MovieStoreService(MovieStore movieStore) {
        this.movieStore = movieStore;
    }

    public String printAllMovieTitles() {
        if (movieStore.getMovies().isEmpty()) {
            System.out.println("No movies available.");
            return null;
        }

        String result = movieStore.getMovies().values().stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.joining(" ! "));
        return result;
    }

}
