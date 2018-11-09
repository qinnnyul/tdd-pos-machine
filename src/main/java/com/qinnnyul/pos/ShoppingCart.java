package com.qinnnyul.pos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<ShoppingItem> shoppingItemList = new ArrayList<>();

    public void add(ShoppingItem shoppingItem) {
        this.shoppingItemList.add(shoppingItem);
    }
}
