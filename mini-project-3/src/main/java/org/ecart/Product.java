package org.ecart;

public class Product {
    private int id;
    private String name;
    private double cost;
    private int quantity;

    public Product(){
        this.id = 0;
        this.name = "";
        this.cost = 0;
        this.quantity = 0;
    }

    public Product(int id, String name, double cost){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = 1;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    // getters
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getCost(){
        return this.cost;
    }

    public int getQuantity() { return this.quantity; };

    // methods
    // adds one to quantity
    public void addQuantity(){
        quantity++;
    }

    // removes an indicated number from amount
    public void removeQuantity(int amount){
        quantity -= amount;
    }
}
