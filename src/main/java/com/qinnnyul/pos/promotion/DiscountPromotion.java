package com.qinnnyul.pos.promotion;

import com.qinnnyul.pos.domain.ShoppingItem;

public class DiscountPromotion extends ShoppingItem {
    private double discount;
    private ShoppingItem shoppingItem;

    public DiscountPromotion(ShoppingItem shoppingItem, double discount) {
        super(shoppingItem.getName(), shoppingItem.getPrice(), shoppingItem.getAmount());
        this.discount = discount;
        this.shoppingItem = shoppingItem;
    }

    public double cost() {
        return this.shoppingItem.cost() * discount / 100;
    }
}
