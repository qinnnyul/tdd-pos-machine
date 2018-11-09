package com.qinnnyul.pos;

public class DiscountPromotion {
    private ShoppingItem shoppingItem;
    private double discount;

    public DiscountPromotion(ShoppingItem shoppingItem, double discount) {
        this.shoppingItem = shoppingItem;
        this.discount = discount;
    }

    public double cost() {
        return this.shoppingItem.cost() * discount / 100;
    }
}
