package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
public class ProductBasket {
    private final Product[] products = new Product[5];
    private int index = 0;

    public void addProduct(Product product) {
        if (index >= products.length) {
            System.out.println("Невозможно добавить продукт.");
            return;
        }
        products[index++] = product;
    }
    public boolean containsProductByName(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        index = 0;
    }
    public int totalCost() {
        int cost = 0;
        for (Product product : products) {
            if (product != null) {
                cost += product.getPrice();
            }
        }
        return cost;
    }

    public void printContents() {
        boolean isEmpty = true;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("Корзина пуста.");
        }
    }
}







