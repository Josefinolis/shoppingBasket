package com.company;


import com.company.domain.basket.ShoppingBasket;

public class Main {

    public static void main(String[] args) {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.add("apple");
        shoppingBasket.add("banana");
        shoppingBasket.add("orange");
        shoppingBasket.add("orange");
        shoppingBasket.add("papaya");
        shoppingBasket.add("papaya");
        shoppingBasket.add("papaya");
        System.out.println(shoppingBasket.getReceipt());
    }
}
