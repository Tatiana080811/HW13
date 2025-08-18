package org.skypro.skyshop.product;

public abstract class Product {
    protected final String name;
    private final double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }
    public abstract double getPrice();

    public abstract boolean isSpecial();

    @Override
    public abstract String toString();
}
