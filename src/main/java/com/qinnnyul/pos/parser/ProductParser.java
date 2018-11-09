package com.qinnnyul.pos.parser;

public class ProductParser extends Parser{

    @Override
    public Product convert(String line) {
        String[] productionInfo = line.split(":");
        return new Product(productionInfo[0], Double.valueOf(productionInfo[1]));
    }
}
