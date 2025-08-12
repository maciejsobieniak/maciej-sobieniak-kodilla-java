package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests () {
        System.out.println("Start tests library module");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    @DisplayName("Test list books with conditions return list")
    void testListBooksWithConditionsReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    @DisplayName("Test list books with conditions return 0, 15, 40 book List")
    void testListBooksWithConditionMoreThan20() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    @DisplayName("Test list books with conditions fragment shorter than 3 and return 0 book List")
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    @DisplayName("Test list books in hands of user with no book, 1 book and 5 books")
    void testListBooksInLibraryUserHands() {
        // Given
        LibraryUser libraryUserWithNoBook = new LibraryUser("Jon", "Smith", "12345");
        LibraryUser libraryUserWith1Book = new LibraryUser("Baiden", "Smith", "12345");
        LibraryUser libraryUserWith5Book = new LibraryUser("John", "Smith", "12345");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Book = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);

        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWithNoBook)).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith1Book)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUserWith5Book)).thenReturn(resultListOf5Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUserWithNoBook);
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUserWith1Book);
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUserWith5Book);

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(1, theListOfBooks1.size());
        assertEquals(5, theListOfBooks5.size());

    }
}
