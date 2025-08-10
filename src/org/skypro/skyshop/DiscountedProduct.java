package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final int discountPercentage;

    public DiscountedProduct(String name, double basePrice, int discountPercentage) {
        super(name, basePrice);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return super.getBasePrice() * (1 - discountPercentage / 100.0);
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercentage + "%)";
    }

    public static class SimpleProduct extends Product {
        private final double price;


        public SimpleProduct(String name, double price) {
            super(name, price); // Обратите внимание, второй аргумент — цена
            this.price = price;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public boolean isSpecial() {
            return false;
        }

        @Override
        public String toString() {
            return getName() + ": " + getPrice();
        }
    }
}




