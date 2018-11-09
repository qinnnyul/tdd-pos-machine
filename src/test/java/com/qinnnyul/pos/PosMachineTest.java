package com.qinnnyul.pos;

import com.qinnnyul.pos.domain.Recipit;
import com.qinnnyul.pos.domain.ShoppingCart;
import com.qinnnyul.pos.domain.ShoppingItem;
import com.qinnnyul.pos.promotion.DiscountPromotion;
import com.qinnnyul.pos.promotion.SecondHalfPricePromotion;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PosMachineTest {

    @Test
    public void shouldCheckoutItemWhichSuitableForMultipleDiscount() throws Exception {
        PosMachine pos = new PosMachine();

        ShoppingCart shoppingCart = new ShoppingCart();

        DiscountPromotion discountPromotion = new DiscountPromotion(new SecondHalfPricePromotion(new ShoppingItem("ITEM000001", 40d, 2)), 75d);
        shoppingCart.add(discountPromotion);


        Recipit recipit = pos.checkout(shoppingCart);
        assertThat(recipit.getTotalPrice(), is(45d));
    }
}