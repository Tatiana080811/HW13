package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.service.model.search.product.Product;
import org.skypro.skyshop.service.model.search.Searchable;
import org.skypro.skyshop.service.model.search.product.article.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        List<Searchable> searchables = new ArrayList<>();
        searchables.add(new Product("Яблоко", 50));
        searchables.add(new Article("Яблоко", "Описание яблока"));

        try {
            String searchQuery = "Яблоко";
            Searchable bestMatch = SearchEngine.findBestMatch(searchables, searchQuery);
            System.out.println("Лучшая находка: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        ProductBasket basket = new ProductBasket();
        Product simpleProduct = new Product("Простой персик", 100.0);
        Product discountedProduct = new DiscountedProduct("Персик со скидкой", 100.0, 10);
        Product fixedPriceProduct = new FixPriceProduct("Фиксированная цена", 50.00);

        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixedPriceProduct);

        System.out.println("== Товары в корзине ==");
        basket.printContents();

        System.out.println("Общая сумма корзины: " + basket.totalCost());

        System.out.println("=== Проверка наличия товаров ====");
        System.out.println("Имеется ли простой персик? " + basket.containsProductByName("Простой персик"));
        System.out.println("Имеется ли персик со скидкой? " + basket.containsProductByName("Персик со скидкой"));

        basket.clearBasket();

        System.out.println("\n== Продукты после очистки корзины ==");
        basket.printContents();
        System.out.println("Сумма пустой корзины: " + basket.totalCost());

        System.out.println("\n== Добавляем обратно товары ==");
        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixedPriceProduct);

        System.out.println("== Список товаров в корзине ==");
        basket.printContents();

        System.out.println("\n== Информация о продуктах ==");
        System.out.println("Название простого персика: " + simpleProduct.getName());
        System.out.println("Цена простого персика: " + simpleProduct.getPrice());
        System.out.println("Специальный продукт? " + simpleProduct.isSpecial());

        System.out.println("Название персика со скидкой: " + discountedProduct.getName());
        System.out.println("Цена персика со скидкой: " + discountedProduct.getPrice());
        System.out.println("Специальный продукт? " + discountedProduct.isSpecial());

        System.out.println("Название товара с фиксированной ценой: " + fixedPriceProduct.getName());
        System.out.println("Цена товара с фиксированной ценой: " + fixedPriceProduct.getPrice());
        System.out.println("Специальный продукт? " + fixedPriceProduct.isSpecial());
    }
}
