package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 70);
        Product orange = new Product("Апельсин", 80);
        Product grapefruit = new Product("Грейпфрут", 100);
        Product kiwi = new Product("Киви", 60);
        Product melon = new Product("Дыня", 150);

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grapefruit);
        basket.addProduct(kiwi);
        basket.addProduct(melon);

        System.out.println("Содержание корзины:");
        basket.printContents();

        System.out.println("Стоимость корзины: " + basket.totalCost());

        System.out.println("Есть ли Банан в корзине? " + basket.containsProductByName("Банан"));
        System.out.println("Есть ли Дыня в корзине? " + basket.containsProductByName("Дыня"));
        basket.clearBasket();


        System.out.println("Корзина после очистки:");
        basket.printContents();
        System.out.println("Стоимость пустой корзины: " + basket.totalCost());
        System.out.println("Есть ли Яблоко в пустой корзине? " + basket.containsProductByName("Яблоко")); // Должно вернуть false
    }
}