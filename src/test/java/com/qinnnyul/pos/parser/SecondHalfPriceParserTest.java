package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.SecondHalfItem;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SecondHalfPriceParserTest {

    @Test
    public void shouldLoadSecondHalfItemFromFile() throws Exception {

        SecondHalfPriceParser secondHalfPriceParser = new SecondHalfPriceParser();

        List<SecondHalfItem> secondHalfItemList = secondHalfPriceParser.parse("second_half_price_promotion.txt");

        assertThat(secondHalfItemList.size(), is(2));
        assertThat(secondHalfItemList.get(0).getName(), is("ITEM000001"));
    }
}
