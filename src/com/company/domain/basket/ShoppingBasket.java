package com.company.domain.basket;

import com.company.domain.product.*;

import java.util.HashMap;
import java.util.Map;

/**
 * First of all, some decisions made just for simplicity:
 * I used Java8 and only java8, no frameworks providing DI
 * It is lacking also unitary testing
 * There is no use of real currency, I used double for prices, which is not a good choice due to the loss of precision
 *  when operating with them, but I think it should work fine with the operations requested
 * There is also missing a remove product operation in ShoppingBasket
 * No error management
 */
public class ShoppingBasket {

    private Map<String, Product> products;

    public ShoppingBasket() {
        products = new HashMap<>();
        products.put("apple", new Apple());
        products.put("orange", new Orange());
        products.put("banana", new Banana());
        products.put("papaya", new Papaya());
    }

    public void add(String productKey) {
        Product product = products.get(productKey);
        if (product != null) {
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

    private double getTotalPrice() {
        double result = 0;
        for (Product product : products.values()) {
            result += product.getTotalPrice();
        }

        return result;
    }

}
