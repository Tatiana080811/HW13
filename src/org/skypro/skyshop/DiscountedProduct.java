package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    private final double discountPercentage;

    public DiscountedProduct(String name, double basePrice, double discountPercentage) {
        super(name, basePrice);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100 включительно.");
        }
        this.discountPercentage = discountPercentage;
    }


    @Override
    public double getPrice() {
        return super.getBasePrice() * (1 - discountPercentage / 100.0);
    }

    public double getDiscountPercentage() {
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

    static class SimpleProduct extends Product {
        private final double price;


        public SimpleProduct(String name, double basePrice, double price) {
            super(name, basePrice);
            this.price = price;
        }

        @Override
        public double getPrice() {
            return super.getBasePrice();
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





