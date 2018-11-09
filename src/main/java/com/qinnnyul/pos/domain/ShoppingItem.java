package com.qinnnyul.pos.domain;

public class ShoppingItem {
    private String name;
    private double price;
    private int amount;

    public ShoppingItem(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }


    public double cost() {
         return price * amount;
    }
}
