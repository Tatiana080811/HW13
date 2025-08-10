package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;
    private double totalCost;

    public ProductBasket() {
        products = new ArrayList<>();
        totalCost = 0.0;
    }

    public void addProduct(Product product) {
        products.add(product);
        updateTotalCost();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        updateTotalCost();
    }

    public void clearBasket() {
        products.clear();
        totalCost = 0.0;
    }

    public double totalCost() {
        return totalCost;
    }

    private void updateTotalCost() {
        totalCost = products.stream().mapToDouble(Product::getPrice).sum();
    }

    public boolean containsProductByName(String name) {
        return products.stream().anyMatch(p -> p.getName().equals(name));
    }

    public void printContents() {
        long specialCount = products.stream().filter(Product::isSpecial).count();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }
}






