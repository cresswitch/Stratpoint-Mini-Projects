// Written by: Beatriz Franco
// BookCollection.java
// Contains BookCollection Object (set of books that is not whole library)

package org.example;

import java.util.ArrayList;

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
        for (int a = 0; a < this.bookList.size(); a++) {
            System.out.println(a+1);
            System.out.println("Title: " + this.bookList.get(a).getTitle());
            System.out.println("Author: " + this.bookList.get(a).getAuthor());
            System.out.println("ISBN: " + this.bookList.get(a).getIsbn());
            System.out.println(" ");
        }
    }

    public void addBook(Book book){
        this.bookList.add(book);
    }
}
