// Written by: Beatriz Franco
// Test.java
// Contains test cases

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Book;
import org.example.Library;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class LibraryTest {

    @Test
    void directAddRemove(){
        Library library = new Library();
        Scanner scanner = new Scanner("y\n");

        // check that library is empty at initialization
        assertEquals(0, library.getBookList().size());

        // check that library has one book after adding
        library.addBook(new Book("book1", "auth1", "1-111-11111-1"));
        assertEquals(1, library.getBookList().size());

        // check that library is empty after removing
        library.removeBook("book1", scanner);
        assertEquals(0, library.getBookList().size());
    }

    @Test
    void userAdd(){
        Library library = new Library();
        Scanner scanner = new Scanner("book1\nauth1\n1111111111\n");

        library.addBook(scanner);

        // check that a book was added
        assertEquals(1, library.getBookList().size());
    }

    @Test
    void search(){
        // create library and ensure all books are added
        Library library = new Library();
        library.addBook(new Book("book1", "auth1", "1-111-11111-1"));
        library.addBook(new Book("book2", "auth2", "2-222-22222-2"));
        library.addBook(new Book("book3", "auth1", "3-333-33333-3"));
        assertEquals(3, library.getBookList().size());

        // test for content and number of correct search results
        assertEquals(library.searchBook("auth1").getBookList().get(0), library.getBookList().get(0));
        assertEquals(library.searchBook("auth1").getBookList().get(1), library.getBookList().get(2));
        assertEquals(2, library.searchBook("auth1").getBookList().size());

        // test for possibility of search with no results
        assertEquals(0, library.searchBook("auth3").getBookList().size());
    }

}