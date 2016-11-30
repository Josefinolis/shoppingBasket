package com.company.domain.product;

public class Papaya extends Product {

    public Papaya() {
        super("Papaya", 50);
    }

    @Override
    public double getTotalPrice() {
        int discountedUnits = getQuantity() / 3;

        return getPricePerUnit() * (getQuantity() - discountedUnits);
    }

}
