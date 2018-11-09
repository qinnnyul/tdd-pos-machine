package com.qinnnyul.pos.parser;

public class DiscountPromotionParser extends Parser{

    @Override
    public DiscountItem convert(String line) {
        String[] stringInfo = line.split(":");
        return new DiscountItem(stringInfo[0], Double.valueOf(stringInfo[1]));
    }
}
