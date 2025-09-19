package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ProductBasket {
    public List<Product> products;
    public double totalCost;


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

    public List<Product> removeAllProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();

            if (currentProduct.getName().equals(name)) {
                removedProducts.add(currentProduct);
                iterator.remove();
            }
        }
            updateTotalCost();
            return removedProducts;
        }

    }








