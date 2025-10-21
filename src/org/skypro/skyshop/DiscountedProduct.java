package org.skypro.skyshop;
import java.util.UUID;
import org.skypro.skyshop.service.model.search.product.Product;

public class DiscountedProduct extends Product {
    private final double discountPercentage;
    private final UUID id;

    public DiscountedProduct(String name, double basePrice, double discountPercentage) {
        super(name, basePrice);
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть от 0 до 100 включительно.");
        }
        this.discountPercentage = discountPercentage;
        this.id = UUID.randomUUID();
    }
    @Override
    public UUID getId() {
        return id;
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

    static abstract class SimpleProduct extends Product {
        public SimpleProduct(String name, double basePrice) {
            super(name, basePrice);
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





