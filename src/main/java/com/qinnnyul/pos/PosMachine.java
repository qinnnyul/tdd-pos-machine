package com.qinnnyul.pos;

import com.qinnnyul.pos.domain.Recipit;
import com.qinnnyul.pos.domain.ShoppingCart;
import com.qinnnyul.pos.domain.ShoppingItem;

public class PosMachine {


    public Recipit checkout(ShoppingCart shoppingCart) {
        Recipit recipit = new Recipit();

        Double totalPrice = shoppingCart.getShoppingItemList().stream().map(ShoppingItem::cost).reduce(0d, (cost, cost2) -> cost + cost2);

        recipit.setTotalPrice(totalPrice);

        return recipit;
    }
}
