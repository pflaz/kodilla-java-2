package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        // Given
        Library library = new Library("Library 1");
        for (int bookNumber = 1; bookNumber <= 10; bookNumber++) {
            library.getBooks().add(new Book("Title " + bookNumber, "Author " + bookNumber, LocalDate.now().minusMonths(bookNumber)));
        }

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        clonedLibrary.setName("Shallow cloned library");

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        deepClonedLibrary.setName("Deep cloned library");

        // When

        library.getBooks().add(new Book("Added book's title", "Added author's name", LocalDate.now()));

        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        // Then
        Assert.assertEquals(11, library.getBooks().size());
        Assert.assertEquals(11, clonedLibrary.getBooks().size());
        Assert.assertEquals(10, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }

}