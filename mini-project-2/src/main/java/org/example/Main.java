// Written by: Beatriz Franco
// Main.java
// Contains Main class with user interaction

package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // main function
        Library library = new Library();

        // test library additions
        library.addBook(new Book("book1", "author1", "1-111-11111-1"));
        library.addBook(new Book("book2", "author2", "2-222-22222-2"));
        library.addBook(new Book("book3", "author1", "3-333-33333-3"));

        // misc initializing
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        String response;
        String title;
        String author;
        String isbn;
        Pattern isbnFormat13 = Pattern.compile("\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d");
        Pattern isbnFormat10 = Pattern.compile("\\d-\\d{3}-\\d{5}-\\d");

        // user loop
        while(continueLoop){
            System.out.println("Enter 'a' to add book, 'p' to see all books, 'r' to remove a book, 's' to search for a book, or anything else to exit.");
            response = scanner.nextLine().toLowerCase();
            switch (response) {
                case "a" -> {
                    // add a book
                    System.out.print("Enter the title: ");
                    title = scanner.nextLine();

                    System.out.print("Enter the author: ");
                    author = scanner.nextLine();

                    // check ISBN format
                    while (true) {
                        System.out.print("Enter the ISBN: ");
                        isbn = scanner.nextLine();
                        try {
                            if (isbnFormat10.matcher(isbn).matches()
                                    || isbnFormat13.matcher(isbn).matches()) {
                                break;
                            } else {
                                throw new Exception("Invalid ISBN");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid ISBN! Please enter a 10 or 13 digit ISBN with dashes.");
                            System.out.println("Format: X-XXX-XXXXX-X or XXX-X-XX-XXXXXX-X");
                        }
                    }

                    // new Book in Library
                    library.addBook(new Book(title, author, isbn));
                }
                case "p" ->
                    // print library
                        library.printBookList();
                case "r" -> {
                    // remove book/s
                    System.out.print("Remove: ");
                    library.removeBook(scanner.nextLine(), scanner);
                }
                case "s" -> {
                    // search for book/s
                    System.out.print("Search for: ");
                    library.searchBook(scanner.nextLine());
                }
                default ->
                    // exit loop
                        continueLoop = false;
            }
        }
    }
}