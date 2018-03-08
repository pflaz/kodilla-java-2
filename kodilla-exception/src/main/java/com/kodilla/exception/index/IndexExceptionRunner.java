package com.kodilla.exception.index;

import java.util.List;

public class IndexExceptionRunner {
    public static void main(String[] args) {
        VideoCollector videoCollector = new VideoCollector();
        List<String> collection = videoCollector.getCollection();
        try {
            String movie = collection.get(1);
            System.out.println(movie);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e);
        }

    }
}
