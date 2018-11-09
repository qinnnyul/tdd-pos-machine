package com.qinnnyul.pos.promotion;

import com.qinnnyul.pos.domain.ShoppingItem;

public class SecondHalfPricePromotion extends ShoppingItem {

    public SecondHalfPricePromotion(ShoppingItem shoppingItem) {
        super(shoppingItem.getName(), shoppingItem.getPrice(), shoppingItem.getAmount());
    }

    public double cost() {
        if (super.getAmount() % 2 == 0) {
            return super.getPrice() * (super.getAmount() / 2 * 1.5);
        } else {
            return super.getPrice() * ((super.getAmount() + 1) / 2 + (super.getAmount() - 1) / 2 * 0.5);
        }
    }
}
