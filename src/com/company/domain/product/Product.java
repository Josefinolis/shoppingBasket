package com.company.domain.product;

import java.math.BigDecimal;

/**
 * Abstract because I want to force the creation of concrete products
 * Didn't take into account currency symbol, as long as we only want to print it, we could put into toString
 */
public abstract class Product {

    private String name;
    private BigDecimal pricePerUnit;
    private int quantity;

    protected Product(String name, BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = 0;
    }

    public BigDecimal getTotalPrice() {
        return pricePerUnit.multiply(new BigDecimal(quantity));
    }

    public String toString() {
        return String.format("%-10s x %2d -> %8.2f = %8.2f", name, quantity, pricePerUnit, getTotalPrice());
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addProduct(){
        quantity++;
    }

}
