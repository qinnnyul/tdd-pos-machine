package com.qinnnyul.pos;

public class DiscountPromotion extends ShoppingItem {
    private ShoppingItem shoppingItem;
    private double discount;

    public DiscountPromotion(ShoppingItem shoppingItem, double discount) {
        super(shoppingItem.getName(), shoppingItem.getPrice(), shoppingItem.getAmount());
        this.shoppingItem = shoppingItem;
        this.discount = discount;
    }

    public double cost() {
        return this.shoppingItem.cost() * discount / 100;
    }
}
