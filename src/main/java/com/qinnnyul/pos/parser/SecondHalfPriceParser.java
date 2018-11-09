package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.SecondHalfItem;

public class SecondHalfPriceParser extends Parser{

    @Override
    protected SecondHalfItem convert(String line) {
        return new SecondHalfItem(line);
    }
}
