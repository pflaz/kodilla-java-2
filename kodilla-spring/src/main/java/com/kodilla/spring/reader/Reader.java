package com.kodilla.spring.reader;

public class Reader {
    private final Book theBook;

    public Reader(final Book theBook) {
        this.theBook = theBook;
    }

    public void read() {
        System.out.println("Reading: " + theBook.getTitle());
    }
}
