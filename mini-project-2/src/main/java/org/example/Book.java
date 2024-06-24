// Written by: Beatriz Franco
// Book.java
// Contains Book object

package org.example;

public class Book {
    // private attributes for safety
    private String title;
    private String author;
    private String isbn;

    // initialize empty Book object without initial values
    public Book(){
        title = "";
        author = "";
        isbn = "";
    }

    // initialize new Book object with initial values
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // setter methods
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    // getter methods
    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getIsbn(){
        return this.isbn;
    }
}
