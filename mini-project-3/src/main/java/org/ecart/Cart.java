package org.ecart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private ArrayList<Product> products;

    // empty constructor
    public Cart(){
        products = new ArrayList<>();
    }

    // constructor from list of products
    public Cart(ArrayList<Product> products){
        this.products = products;
    }

    // constructor from existing cart
    public Cart(Cart cart){
        products = cart.getProducts();
    }

    // setter and getter
    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    // methods
    // return index of corresponding product, or -1 if it is not in list
    public int containsProduct(int id){
        for(int a = 0; a < getProducts().size(); a++){
            if(products.get(a).getId() == id){
                // if product is already in cart, return index
                return a;
            }
        }
        // return -1 if it is not yet in cart
        return -1;
    }

    // similar method but for name instead of id, not used
    public int containsProduct(String name){
        for(int a = 0; a < getProducts().size(); a++){
            if(products.get(a).getName().equalsIgnoreCase(name)){
                // if product is already in cart, return index
                return a;
            }
        }
        // return -1 if it is not yet in cart
        return -1;
    }

    // adds product to cart
    public void addProduct(Scanner scanner){
        int id = 0;
        String name;
        double cost = 0;
        while(true){
            try{
                System.out.print("Enter ID of item: ");
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Error, invalid input.");
            }
        }
        int index = this.containsProduct(id);
        if(index > -1){
            this.getProducts().get(index).addQuantity();
            System.out.println("Added " + this.getProducts().get(index).getName());
        }
        else{
            System.out.print("Enter name of product: ");
            name = scanner.nextLine();
            while(true){
                try{
                    System.out.print("Enter cost of item: ");
                    cost = Double.parseDouble(scanner.nextLine());
                    break;
                } catch(Exception e){
                    System.out.println("Error, invalid input.");
                }
            }
            this.getProducts().add(new Product(id, name, cost));
        }
    }

    // calculates total price
    public double totalPrice(){
        double result = 0;
        for(Product a : this.getProducts()){
            result += a.getCost() * a.getQuantity();
        }

        return result;
    }

    // prints all items in cart and total price
    public void printTotal(){
        final DecimalFormat decfor = new DecimalFormat("0.00");
        if(products.isEmpty()){
            System.out.println("No products in cart.");
        }
        else{
            for(Product a : this.getProducts()){
                System.out.println(a.getId() + " " + a.getName() + " x " + a.getQuantity() + " = " + decfor.format(a.getQuantity() * a.getCost()));
            }
        }
        System.out.println("Total price: " + decfor.format(this.totalPrice()));
    }

    // remove 1 or more of a product from cart
    public void removeProduct(Scanner scanner){
        int id;
        int index;
        System.out.print("Input ID of item to be removed: ");
        while(true){
            try{
                id = Integer.parseInt(scanner.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Error, please enter a valid ID.");
            }
        }
        index = this.containsProduct(id);
        if(index > -1 && this.getProducts().get(index).getQuantity() > 1){
            System.out.print("Remove how many? ");
            while(true){
                try{
                    int toRemove = Integer.parseInt(scanner.nextLine());
                    if(toRemove <= this.getProducts().get(index).getQuantity()){
                        this.getProducts().get(index).removeQuantity(toRemove);
                    }
                    else{
                        throw new Exception("Invalid amount to be removed");
                    }
                    break;
                } catch(Exception e){
                    System.out.println("Error, invalid input.");
                }
            }
            System.out.println("Removal successful.");
            if(this.getProducts().get(index).getQuantity() == 0){
                this.getProducts().remove(index);
            }
        }
        else if(index > -1 && this.getProducts().get(index).getQuantity() == 1){
            this.getProducts().get(index).removeQuantity(1);
            System.out.println("Removal successful.");
            if(this.getProducts().get(index).getQuantity() == 0){
                this.getProducts().remove(index);
            }
        }
        else{
            System.out.println("No such item in cart. Removal unsuccessful.");
        }
    }
}
