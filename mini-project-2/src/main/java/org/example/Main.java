// Written by: Beatriz Franco
// Main.java
// Contains Main class with user interaction

package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // main function
        Library library = new Library();

        // misc initializing
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        String response;

        // user loop
        while(continueLoop){
            System.out.println("Enter 'a' to add book, 'p' to see all books, 'r' to remove a book, 's' to search for a book, or anything else to exit.");
            response = scanner.nextLine().toLowerCase();
            switch (response) {
                case "a" -> {
                    // add a book
                    library.addBook(scanner);
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