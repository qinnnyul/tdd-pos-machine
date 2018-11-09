package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.ShoppingCartItem;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartParserTest {

    @Test
    public void shouldLoadShoppingCartFromFile() throws Exception {
        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();

        List<ShoppingCartItem> shoppingCartItemList = shoppingCartParser.parse("cart.txt");


        assertThat(shoppingCartItemList.size(), is(3));
        assertThat(shoppingCartItemList.get(0).getName(), is("ITEM000001"));
        assertThat(shoppingCartItemList.get(0).getAmount(), is(5d));
        assertThat(shoppingCartItemList.get(2).getName(), is("ITEM000005"));
        assertThat(shoppingCartItemList.get(2).getAmount(), is(4d));
        assertThat(shoppingCartItemList.get(1).getName(), is("ITEM000003"));
        assertThat(shoppingCartItemList.get(1).getAmount(), is(2d));

    }
}
