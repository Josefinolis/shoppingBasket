package com.company.domain.basket;

import com.company.domain.product.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    Map<String, Product> products;

    public ShoppingBasket() {
        products = new HashMap<>();
        products.put("apple", new Apple());
        products.put("orange", new Orange());
        products.put("banana", new Banana());
        products.put("papaya", new Papaya());
    }

    public void add(String productKey) {
        Product product = products.get(productKey);
        if(product != null) {
            product.addProduct();
        }//Custom exception could be thrown here, like ProductNotFoundInBasketException
    }

    public String getReceipt() {
        StringBuilder stringBuilder = new StringBuilder();

        products.values().forEach(product -> stringBuilder.append(product).append("\n"));
        //31 length for formatting just to fit items prices
        stringBuilder.append(String.format("Total: %31.2f\n", getTotalPrice()));

        return stringBuilder.toString();
    }

    private BigDecimal getTotalPrice() {
        BigDecimal result = new BigDecimal(0);
        for(Product product : products.values()) {
            result = result.add(product.getTotalPrice());
        }

        return result;
    }

}
