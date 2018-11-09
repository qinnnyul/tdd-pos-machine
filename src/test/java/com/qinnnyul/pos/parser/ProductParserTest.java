package com.qinnnyul.pos.parser;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductParserTest {
    @Test
    public void shouldLoadProductFromFile() throws Exception {
        ProductParser productParser = new ProductParser();
        List<Product> products = productParser.parse("itemlist.txt");

        assertThat(products.size(), is(3));
        assertThat(products.get(0).getName(), is("ITEM000001"));
        assertThat(products.get(0).getPrice(), is(40d));
    }
}
