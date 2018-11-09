package com.qinnnyul.pos.parser;

import com.qinnnyul.pos.domain.ShoppingCartItem;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ShoppingCartParser extends Parser<ShoppingCartItem> {

    @Override
    public List<ShoppingCartItem> parse(String fileName) {
        List<ShoppingCartItem> shoppingCartItems = super.parse(fileName);
        return reduceDuplicated(shoppingCartItems);
    }

    private List<ShoppingCartItem> reduceDuplicated(List<ShoppingCartItem> shoppingCartItems) {
        Map<String, Double> reducedShoppingCartMap = new TreeMap<>();

        for (ShoppingCartItem shoppingCartItem : shoppingCartItems) {
            if (!reducedShoppingCartMap.keySet().contains(shoppingCartItem.getName())) {
                reducedShoppingCartMap.put(shoppingCartItem.getName(), shoppingCartItem.getAmount());
            } else {
                Double amount = reducedShoppingCartMap.get(shoppingCartItem.getName());
                reducedShoppingCartMap.put(shoppingCartItem.getName(), shoppingCartItem.getAmount() + amount);
            }
        }

        return reducedShoppingCartMap.keySet().stream().map(name -> new ShoppingCartItem(name, reducedShoppingCartMap.get(name))).collect(Collectors.toList());
    }

    @Override
    protected ShoppingCartItem convert(String line) {

        String[] stringInfo = line.split("-");

        if (stringInfo.length == 2) {
            return new ShoppingCartItem(stringInfo[0], Double.valueOf(stringInfo[1]));
        }
        return new ShoppingCartItem(stringInfo[0], 1);
    }
}
