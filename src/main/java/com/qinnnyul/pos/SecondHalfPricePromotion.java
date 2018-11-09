package com.qinnnyul.pos;

public class SecondHalfPricePromotion {

    private ShoppingItem shoppingItem;

    public SecondHalfPricePromotion(ShoppingItem shoppingItem) {

        this.shoppingItem = shoppingItem;
    }

    public double cost() {
        return (this.shoppingItem.getAmount() + 1) * this.shoppingItem.getPrice() * 0.5;
    }
}
