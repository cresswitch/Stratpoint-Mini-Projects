// Written by: Beatriz Franco
// BookCollection.java
// Contains BookCollection Object (set of books that is not whole library)

package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BookCollection {
    // protected and not private so Library can also access it
    protected ArrayList<Book> bookList;

    // initialize new empty BookCollection
    public BookCollection(){
        bookList = new ArrayList<>();
    }

    // initialize new BookCollection from existing BookCollection
    public BookCollection(BookCollection books){
        this.bookList = books.getBookList();
    }

    // setter
    public void setBookList(ArrayList<Book> books){
        this.bookList = books;
    }

    // getter
    public ArrayList<Book> getBookList(){
        return this.bookList;
    }

    // methods
    public void printBookList(){
        if(this.bookList.isEmpty()){
            System.out.println("No books in this library yet.");
        }
        else{
            for (int a = 0; a < this.bookList.size(); a++) {
                System.out.println(a+1);
                System.out.println("Title: " + this.bookList.get(a).getTitle());
                System.out.println("Author: " + this.bookList.get(a).getAuthor());
                System.out.println("ISBN: " + this.bookList.get(a).getIsbn());
                System.out.println(" ");
            }
        }
    }

    // method to add book from existing book
    public void addBook(Book book){
        this.bookList.add(book);
    }

    // method to add book from user input
    public void addBook(Scanner scanner){
        Pattern isbnFormat13 = Pattern.compile("\\d{13}");
        Pattern isbnFormat10 = Pattern.compile("\\d{10}");
        String title, author, isbn = "";

        // prevent empty title
        while(true){
            System.out.print("Enter the title: ");
            title = scanner.nextLine();
            try{
                if(title.equals("\n")){
                    break;
                }
                else{
                    throw new Exception("Empty string");
                }
            } catch(Exception e){
                System.out.println("Empty string detected. Please enter some text.");
            }
        }

        // prevent empty author
        while(true){
            System.out.print("Enter the author: ");
            author = scanner.nextLine();
            try{
                if(author.equals("\n")){
                    break;
                }
                else{
                    throw new Exception("Empty string");
                }
            } catch(Exception e){
                System.out.println("Empty string detected. Please enter some text.");
            }
        }

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
                System.out.println("Invalid ISBN. Please enter a 10 or 13 digit ISBN without dashes.");
            }
        }
        this.bookList.add(new Book(title, author, isbn));
        System.out.println("Book added.");
    }
}
