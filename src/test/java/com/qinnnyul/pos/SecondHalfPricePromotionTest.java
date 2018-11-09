package com.qinnnyul.pos;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPricePromotionTest {
    @Test
    public void shouldGiveSecondHalfPriceDiscount() throws Exception {
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000003", 50d, 2);
        SecondHalfPricePromotion secondHalfPricePromotion = new SecondHalfPricePromotion(shoppingItem);
        double cost = secondHalfPricePromotion.cost();
        assertThat(cost, is(75d));

    }
}
