package com.qinnnyul.pos;

public class SecondHalfPricePromotion extends ShoppingItem {

    private ShoppingItem shoppingItem;

    public SecondHalfPricePromotion(ShoppingItem shoppingItem) {
        super(shoppingItem.getName(), shoppingItem.getPrice(), shoppingItem.getAmount());
        this.shoppingItem = shoppingItem;
    }

    public double cost() {
        return (this.shoppingItem.getAmount() + 1) * this.shoppingItem.getPrice() * 0.5;
    }
}
