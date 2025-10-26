package com.kodilla.good.patterns.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library of Koszalin City - 1");
        Book book1 = new Book("1984", "George Orwell", LocalDate.of(1923, 10, 1));
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1960, 1, 1));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library of Szczecin City - 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library of Gdansk City - 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(2, library.getBooks().size());
    }
}
