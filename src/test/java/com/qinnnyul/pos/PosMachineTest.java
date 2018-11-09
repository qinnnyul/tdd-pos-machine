package com.qinnnyul.pos;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PosMachineTest {

    @Test
    public void shouldCheckoutItemWhichSuitableForMultipleDiscount() throws Exception {
        PosMachine pos = new PosMachine();

        ShoppingCart shoppingCart = new ShoppingCart();

        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(new ShoppingItem("ITEM000001", 40d, 2));
        DiscountPromotion discountPromotion = new DiscountPromotion(secondHalfPricePromotion, 75d);
        shoppingCart.add(discountPromotion);


        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(45d));
    }
}
