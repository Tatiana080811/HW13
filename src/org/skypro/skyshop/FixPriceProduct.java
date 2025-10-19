package org.skypro.skyshop;

import org.skypro.skyshop.service.model.search.product.Product;

public class FixPriceProduct extends Product {
    private static final double FIXED_PRICE = 100.0;

    public FixPriceProduct(String name, double v) {
        super(name, FIXED_PRICE);
    }

    @Override
    public double getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
