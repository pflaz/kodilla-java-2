package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        // Given
        Book book1 = new Book("Sienkiewicz Henryk", "W pustyni i w puszczy", 2000, "123355");
        Book book2 = new Book("Makuszyński Kornel", "Awantura o Basię", 1998, "92243");
        Book book3 = new Book("Mickiewicz Adam", "Pan Tadeusz", 1997, "3464565");
        Set<Book> bookSet= new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);

        // When
        MedianAdapter medianAdapter = new MedianAdapter();
        int median = medianAdapter.publicatonYearMedian(bookSet);

        // Then
        Assert.assertEquals(1998, median);
    }

}