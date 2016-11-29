package com.company.domain.product;

import java.math.BigDecimal;

public class Papaya extends Product {

    public Papaya() {
        super("Papaya", new BigDecimal(50));
    }

    @Override
    public BigDecimal getTotalPrice() {
        int discountedUnits = getQuantity() / 3;

        return getPricePerUnit().multiply(new BigDecimal(getQuantity() - discountedUnits));
    }

}
