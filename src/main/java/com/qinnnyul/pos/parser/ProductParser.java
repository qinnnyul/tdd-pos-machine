package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.Product;

public class ProductParser extends Parser<Product> {

    @Override
    public Product convert(String line) {
        String[] productionInfo = line.split(":");
        return new Product(productionInfo[0], Double.valueOf(productionInfo[1]));
    }
}
