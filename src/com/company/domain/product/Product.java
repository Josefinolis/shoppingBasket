package com.company.domain.product;

import java.math.BigDecimal;

/**
 * Abstract because I want to force the creation of concrete products
 * Didn't take into account currency symbol, as long as we only want to print it, we could put into toString
 */
public abstract class Product {

    private String name;
    /**
     * Although for currency the use of float and double discouraged due to the loss of precission, I think for
     * this example it is fine
     */
    private double pricePerUnit;
    private int quantity;

    protected Product(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = 0;
    }

    public double getTotalPrice() {
        return pricePerUnit * quantity;
    }

    public String toString() {
        return String.format("%-10s x %2d -> %8.2f = %8.2f", name, quantity, pricePerUnit, getTotalPrice());
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addProduct(){
        quantity++;
    }

}
