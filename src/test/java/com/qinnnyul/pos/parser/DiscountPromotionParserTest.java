package com.qinnnyul.pos.parser;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DiscountPromotionParserTest {

    @Test
    public void shouldLoadDiscountPromotionData() throws Exception {
        DiscountPromotionParser discountPromotionParser = new DiscountPromotionParser();
        List<DiscountItem> discountItemList = discountPromotionParser.parse("discount_promotion.txt");

        assertThat(discountItemList.size(), is(2));
        assertThat(discountItemList.get(0).getName(), is("ITEM000001"));
        assertThat(discountItemList.get(0).getRate(), is(75d));
    }
}
