package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.Searchable;

public class Product implements Searchable {
    protected final String name;
    private final double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Реализация отсутствующего метода
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Продукт: " + this.getName();
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return basePrice;
    }

    public boolean isSpecial() {
        return false;
    }
}