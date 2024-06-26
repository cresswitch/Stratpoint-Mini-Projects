package org.ecart;

public class Product {
    private int id;
    private String type;
    private double cost;

    public Product(){
        this.id = 0;
        this.type = "";
        this.cost = 0;
    }

    public Product(int id, String type, double cost){
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    // setters
    public void setId(int id){
        this.id = id;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    // getters
    public int getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }

    public double getCost(){
        return this.cost;
    }
}
