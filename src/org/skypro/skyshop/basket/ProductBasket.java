package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> productMap = new HashMap<>();
    private double totalCost;

    public ProductBasket() {}

    public void addProduct(Product product) {
        String productName = product.getName();
        productMap.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
        updateTotalCost();
    }

    public void removeProduct(Product product) {
        String productName = product.getName();
        List<Product> productsWithSameName = productMap.get(productName);
        if (productsWithSameName != null && productsWithSameName.contains(product)) {
            productsWithSameName.remove(product);
            if (productsWithSameName.isEmpty()) {
                productMap.remove(productName);
            }
            updateTotalCost();
        }
    }

    public void clearBasket() {
        productMap.clear();
        totalCost = 0.0;
    }

    public double totalCost() {
        return totalCost;
    }

    private void updateTotalCost() {
        totalCost = productMap.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public boolean containsProductByName(String name) {
        return productMap.containsKey(name);
    }

    public void printContents() {
        long specialCount = countSpecialProducts();

        productMap.forEach((name, products) -> {
            System.out.println("Продукт: " + name);
            products.forEach(product -> System.out.println("\t" + product));
        });

        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    private long countSpecialProducts() {
        return productMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public List<Product> removeAllProductsByName(String name) {
        List<Product> removedProducts = productMap.remove(name);
        if (removedProducts != null) {
            updateTotalCost();
        }
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }
}