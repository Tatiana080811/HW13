package org.skypro.skyshop.product;
import java.util.Objects;

import org.skypro.skyshop.basket.Searchable;

public class Product implements Searchable {
    protected final String name;
    private final double basePrice;

    public Product(String name, double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равной 0");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустой строкой");
        }
        this.name = name;
        this.basePrice = basePrice;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
