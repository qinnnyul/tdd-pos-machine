package com.qinnnyul.pos;

import com.qinnnyul.pos.domain.DiscountItem;
import com.qinnnyul.pos.domain.SecondHalfItem;
import com.qinnnyul.pos.domain.ShoppingItem;
import com.qinnnyul.pos.parser.DiscountPromotionParser;
import com.qinnnyul.pos.parser.SecondHalfPriceParser;
import com.qinnnyul.pos.promotion.DiscountPromotion;
import com.qinnnyul.pos.promotion.SecondHalfPricePromotion;

import java.util.List;
import java.util.Optional;

public class PosConfigParser {

    List<DiscountItem> discountItems = new DiscountPromotionParser().parse("discount_promotion.txt");

    List<SecondHalfItem> secondHalfItems = new SecondHalfPriceParser().parse("second_half_price_promotion.txt");


    public ShoppingItem discount(ShoppingItem shoppingItem) {
        ShoppingItem result = shoppingItem;
        Optional<DiscountItem> discountItemOptional = discountItems.stream().filter(discountItem -> discountItem.getName().equals(shoppingItem.getName())).findFirst();
        Optional<SecondHalfItem> secondHalfItemOptional = secondHalfItems.stream().filter(secondHalfItem -> secondHalfItem.getName().equals(shoppingItem.getName())).findFirst();

        if (discountItemOptional.isPresent() && secondHalfItemOptional.isPresent()) {
            result = new DiscountPromotion(new SecondHalfPricePromotion(shoppingItem), discountItemOptional.get().getRate());
        } else if (discountItemOptional.isPresent()) {
            result = new DiscountPromotion(shoppingItem, discountItemOptional.get().getRate());
        } else if (secondHalfItemOptional.isPresent()) {
            result = new SecondHalfPricePromotion(shoppingItem);
        }

        return result;
    }
}
