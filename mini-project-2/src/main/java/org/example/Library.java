// Written by: Beatriz Franco
// Library.java
// Contains Library Object that inherits from BookCollection

package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Library extends BookCollection {
    // initialize new empty Library
    public Library(){
        bookList = new ArrayList<>();
    }

    // initialize new Library from existing BookCollection
    public Library(BookCollection books){
        this.bookList = books.getBookList();
    }

    // methods
    public void removeBook(String str){
        // use search function to look for removable candidates
        BookCollection search = this.searchBook(str);
        Scanner scanner = new Scanner(System.in);

        // no removal if no match
        if(search.getBookList().isEmpty()){
            System.out.println("Removal could not be implemented.");
        }
        // no need to prompt user further if there is only one match
        else if(search.getBookList().size() == 1){
            System.out.print("Are you sure you want to remove " + search.getBookList().get(0).getTitle() + " by " + search.getBookList().get(0).getAuthor() + "? (y/n) ");
            switch(scanner.nextLine().toLowerCase()){
                case "y":
                    this.bookList.remove(search.getBookList().get(0));
                    System.out.println("Removal successful.");
                    break;
                case "n":
                    System.out.println("Removal aborted.");
                    break;
                default:
                    System.out.println("Invalid input, operation aborted.");
                    break;
            }
        }
        // prompt user to choose book for removal
        else{
            System.out.print("Input number of book to be removed: ");

            boolean go = true;
            int index = 0;
            while(go){
                go = false;
                // catch invalid index (non integer or outside array range)
                try{
                    index = Integer.parseInt(scanner.nextLine());
                    if(index > search.getBookList().size()){
                        throw new ArrayIndexOutOfBoundsException();
                    }
                } catch(Exception e){
                    go = true;
                    System.out.println("Please enter an integer within the range.");
                }
            }

            // adjust from display index [1-size] to actual index [0-(size-1)]
            index--;

            System.out.print("Are you sure you want to remove " + search.getBookList().get(index).getTitle() + " by " + search.getBookList().get(index).getAuthor() + "? (y/n) ");
            switch(scanner.nextLine().toLowerCase()){
                case "y":
                    this.bookList.remove(search.getBookList().get(index));
                    System.out.println("Removal successful.");
                    break;
                case "n":
                    System.out.println("Removal aborted.");
                    break;
                default:
                    System.out.println("Invalid input, operation aborted.");
                    break;
            }
        }
    }

    public BookCollection searchBook(String str){
        // new set of books to hold eligible search targets
        // returns exact matches or partial matches (contains the substring being searched for)
        BookCollection search = new BookCollection();
        str = str.toLowerCase();

        for(Book book : this.bookList){
            if(book.getTitle().toLowerCase().equals(str) || book.getAuthor().toLowerCase().equals(str)
                    || book.getIsbn().toLowerCase().equals(str)){
                search.addBook(book);
            }
            else if(book.getTitle().toLowerCase().matches(".*[" + str + "].*")
                    || book.getAuthor().toLowerCase().matches(".*[" + str + "].*")
                    || book.getIsbn().toLowerCase().matches(".*[" + str + "].*")){
                search.addBook(book);
            }
        }

        if(!search.getBookList().isEmpty()){
            System.out.println("We found " + search.getBookList().size() + " result/s:");
        }
        else{
            System.out.println("Sorry, we could not find any matches.");
        }

        search.printBookList();

        return search;
    }
}
