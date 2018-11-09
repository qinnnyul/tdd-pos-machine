package com.qinnnyul.pos;

import com.qinnnyul.pos.domain.*;
import com.qinnnyul.pos.parser.ProductParser;
import com.qinnnyul.pos.parser.ShoppingCartParser;
import com.qinnnyul.pos.promotion.DiscountPromotion;
import com.qinnnyul.pos.promotion.SecondHalfPricePromotion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PosMachineTest {

    private PosMachine pos;

    @Before
    public void setUp() throws Exception {
        pos = new PosMachine();
    }

    @Test
    public void shouldCheckoutItemWhichSuitableForMultipleDiscount() throws Exception {

        ShoppingCart shoppingCart = new ShoppingCart();

        DiscountPromotion discountPromotion = new DiscountPromotion(new SecondHalfPricePromotion(new ShoppingItem("ITEM000001", 40d, 2)), 75d);
        shoppingCart.add(discountPromotion);


        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(45d));
    }



    @Test
    public void shouldGetRightCostForItemOne() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ShoppingItem("ITEM000001", 40d, 5));
        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(120d));
    }

    @Test
    public void shouldGetRightCostForItemThree() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ShoppingItem("ITEM000003", 50d, 2));
        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(75d));
    }

    @Test
    public void shouldGetRightCostForItemFive() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new ShoppingItem("ITEM000005", 60d, 4));
        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(216d));
    }


    @Test
    public void shouldParseInputAndPrintOutExpectedResult() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();

        ProductParser productParser = new ProductParser();
        List<Product> products = productParser.parse("itemlist.txt");

        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
        List<ShoppingCartItem> shoppingCartItems = shoppingCartParser.parse("cart.txt");

        for (ShoppingCartItem shoppingCartItem: shoppingCartItems) {
            shoppingCart.add(new ShoppingItem(shoppingCartItem.getName(), getPrice(shoppingCartItem.getName(), products), shoppingCartItem.getAmount()));
        }

        Recipit recipit = pos.checkout(shoppingCart);

        assertThat(recipit.getTotalPrice(), is(411d));

    }

    private double getPrice(String name, List<Product> products) {
        Optional<Product> productOptional = products.stream().filter(product -> product.getName().equals(name)).findFirst();
        return productOptional.get().getPrice();
    }

}
