package com.qinnnyul.pos.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingItem> shoppingItemList = new ArrayList<>();

    public void add(ShoppingItem shoppingItem) {
        this.shoppingItemList.add(shoppingItem);
    }

    public List<ShoppingItem> getShoppingItemList() {
        return shoppingItemList;
    }
}
