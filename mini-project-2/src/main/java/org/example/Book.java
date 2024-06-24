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
    public Book(String t, String a, String i){
        this.title = t;
        this.author = a;
        this.isbn = i;
    }

    // setter methods
    public void setTitle(String t){
        this.title = t;
    }

    public void setAuthor(String a){
        this.author = a;
    }

    public void setIsbn(String i){
        this.isbn = i;
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
