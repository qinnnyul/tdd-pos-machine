package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.DiscountItem;

public class DiscountPromotionParser extends Parser<DiscountItem> {

    @Override
    public DiscountItem convert(String line) {
        String[] stringInfo = line.split(":");
        return new DiscountItem(stringInfo[0], Double.valueOf(stringInfo[1]));
    }
}
