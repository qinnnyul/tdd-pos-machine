package com.qinnnyul.pos;

import com.qinnnyul.pos.domain.ShoppingItem;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShoppingItemTest {
    @Test
    public void shouldGetCostForSingleShoppingItem() throws Exception {
        String name = "ITEM000001";
        double price = 40d;
        int amount = 2;
        ShoppingItem shoppingItem = new ShoppingItem(name, price, amount);
        double cost = shoppingItem.cost();
        assertThat(cost, is(80d));
    }
}
