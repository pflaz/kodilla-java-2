package com.kodilla.good.patterns.challenges.moviestore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreRunner {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        Map<String, List<String>> movies = movieStore.getMovies();
        String result = movies.entrySet().stream()
                .map(list -> list.getValue())
                .flatMap(translations -> translations.stream())
                .collect(Collectors.joining("!"));

        System.out.println(result);
    }
}
