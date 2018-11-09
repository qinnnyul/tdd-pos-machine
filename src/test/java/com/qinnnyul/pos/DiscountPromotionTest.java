package com.qinnnyul.pos;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiscountPromotionTest {
    @Test
    public void shouldCalculateDiscountPriceForItem() throws Exception {
        ShoppingItem shoppingItem = new ShoppingItem("ITEM000001", 40d, 2);
        DiscountPromotion discountPromotion = new DiscountPromotion(shoppingItem, 75d);
        double discountCost = discountPromotion.cost();
        assertThat(discountCost, is(60d));
    }
}