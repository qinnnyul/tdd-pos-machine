package com.qinnnyul.pos.promotion;

import com.qinnnyul.pos.domain.ShoppingItem;

public class SecondHalfPricePromotion extends ShoppingItem {

    private ShoppingItem shoppingItem;

    public SecondHalfPricePromotion(ShoppingItem shoppingItem) {
        super(shoppingItem.getName(), shoppingItem.getPrice(), shoppingItem.getAmount());
        this.shoppingItem = shoppingItem;
    }

    public double cost() {
        if (this.shoppingItem.getAmount() % 2 == 0) {
            return this.shoppingItem.getPrice() * (this.shoppingItem.getAmount() / 2 * 1.5);
        } else {
            return this.shoppingItem.getPrice() * ((this.shoppingItem.getAmount() + 1) / 2 + (this.shoppingItem.getAmount() - 1) / 2 * 0.5);
        }
    }
}
