package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.Searchable;

public abstract class Product implements Searchable {
    protected final String name;
    private final double basePrice;

    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getSearchTerm() {
        return this.name;
    }

    @Override
    public String getContentTYpe(){
        return "PRODUCT";
    }
    @Override
    public void performSearch(){
        System.out.println("Выполнен поиск по товару: " + this.getSearchTerm());
    }

    @Override
    public String toString(){
        return "Продукт: " + this.getName();
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
