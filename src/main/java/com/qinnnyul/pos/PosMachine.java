package com.qinnnyul.pos;

public class PosMachine {
    public Recipit checkout(ShoppingCart shoppingCart) {
        Recipit recipit = new Recipit();

        Double totalPrice = shoppingCart.shoppingItemList.stream().map(ShoppingItem::cost).reduce(0d, (cost, cost2) -> cost + cost2);

        recipit.setTotalPrice(totalPrice);

        return recipit;
    }
}
