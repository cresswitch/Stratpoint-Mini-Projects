package org.ecart;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        boolean cont = true;

        // user loop
        while(cont){
            System.out.println("Enter a to add product to cart, r to remove product, or p to see what's in the cart. Enter anything else to exit.");
            switch(scanner.nextLine().toLowerCase()){
                case "a":
                    cart.addProduct(scanner);
                    break;
                case "r":
                    cart.removeProduct(scanner);
                    break;
                case "p":
                    cart.printTotal();
                    break;
                default:
                    cont = false;
            }
        }
    }
}