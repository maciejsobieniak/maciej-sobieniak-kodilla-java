package com.kodilla.testing.library;

import java.util.List;
import java.util.ArrayList;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    /**
     * This method returns a list of books that match the given title fragment.
     * If the title fragment is shorter than 3 characters, it returns an empty list.
     * If the result contains more than 20 books, it also returns an empty list.
     *
     * @param titleFragment the fragment of the book title to search for
     * @return a list of books matching the title fragment
     */

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    /**
     * This method returns a list of books borrowed by a specific library user.
     * If the user is null or has no books in hands, it returns an empty list.
     *
     * @param libraryUser the user whose borrowed books are to be listed
     * @return a list of books in hands of the specified library user
     */

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> bookList = new ArrayList<>();
        if (libraryUser == null) return bookList;
        List<Book> resultList = libraryDatabase.listBooksInHandsOf(libraryUser);
        if (resultList.size() == 0)  return bookList;
        bookList = resultList;
        return bookList;
    }
}
