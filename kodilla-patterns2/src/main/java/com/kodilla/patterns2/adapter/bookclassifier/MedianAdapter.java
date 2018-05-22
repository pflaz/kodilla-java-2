package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicatonYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> bookMap = new HashMap<>();

        for (Book bookFromSet: bookSet) {
            BookSignature bookSignature = new BookSignature(bookFromSet.getSignature());
            com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book bookForLibraryB = new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(bookFromSet.getAuthor(), bookFromSet.getTitle(), bookFromSet.getPublicationYear());
            bookMap.put(bookSignature, bookForLibraryB);
        }
        MedianAdaptee medianAdaptee = new MedianAdaptee();
        int medianOnTheBaseOfLibraryBAlgorithm = medianAdaptee.medianPublicationYear(bookMap);
        return medianOnTheBaseOfLibraryBAlgorithm;
    }
}
