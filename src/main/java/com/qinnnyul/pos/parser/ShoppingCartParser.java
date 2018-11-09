package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.ShoppingCartItem;

public class ShoppingCartParser extends Parser{

    @Override
    protected ShoppingCartItem convert(String line) {

        String[] stringInfo = line.split("-");

        if (stringInfo.length == 2) {
            return new ShoppingCartItem(stringInfo[0], Double.valueOf(stringInfo[1]));
        }
        return new ShoppingCartItem(stringInfo[0], 1);
    }
}
