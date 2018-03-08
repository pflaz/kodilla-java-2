package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BooksInHandsTestSuite {

    private List<Book> generateBooksList(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();

        for (int i = 0; i < booksQuantity; i++) {
            Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksInHandsOfUserWith0Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks0 = new ArrayList<Book>();
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "71111111111");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks0);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(0, theListOfBooks0.size());
    }

    @Test
    public void testListBooksInHandsOfUserWith1Book() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks1 = generateBooksList(1);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "71111111111");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks1);

        // When
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(1, theListOfBooks1.size());
    }

    @Test
    public void testListBooksInHandsOfUserWith5Books() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks5 = generateBooksList(5);
        LibraryUser libraryUser = new LibraryUser("John", "Smith", "71111111111");
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks5);

        // When
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser);

        // Then
        Assert.assertEquals(5, theListOfBooks5.size());
    }
}
