package org.skypro.skyshop;

import org.skypro.skyshop.basket.*;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.basket.ArticleComparator;

import java.util.*;


public class App {
    public static void main(String[] args) {
        Set<Searchable> searchables = new HashSet<>();
        searchables.add(new Product("Яблоко", 50));
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Статья о яблоках", "Описание статьи о яблоках"));
        articles.add((new Article("Статья о грушах", "Описание статьи о грушах")));

        String searchQuery = "Яблоко";
        try {
            Set<Searchable> foundItems = SearchEngine.findAllMatches(searchables, searchQuery);
            List<Searchable> sortedResults = new ArrayList<>(foundItems);
            sortedResults.sort(new ArticleComparator());

            System.out.println("Подходящие результаты (отсортированные):");
            for (Searchable item : sortedResults) {
                System.out.println(item.toString());
            }
        }catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }


        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 70);
        Product orange = new Product("Апельсин", 80);
        Product grapefruit = new Product("Грейпфрут", 110);
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

        System.out.println("Общая стоимость корзины: " + basket.totalCost());

        System.out.println("Есть ли банан в корзине? " + basket.containsProductByName("Банан"));
        System.out.println("Есть ли дыня в корзине? " + basket.containsProductByName("Дыня"));

        basket.clearBasket();

        System.out.println("Корзина после очистки:");
        basket.printContents();
        System.out.println("Стоимость пустой корзины: " + basket.totalCost());
        System.out.println("Есть ли яблоко в пустой корзине? " + basket.containsProductByName("Яблоко"));

        Product simpleProduct = new Product("Персик", 50.0);
        Product discountedProduct = new Product("Перец", 100.0);
        Product fixedPriceProduct = new Product("Курага", 120.0);
        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixedPriceProduct);

        System.out.println("=== Текущее содержание корзины ===");
        basket.printContents();

        System.out.println("== Дополнительная проверка ==");
        System.out.println("Название простого товара: " + simpleProduct.getName());
        System.out.println("Цена простого товара: " + simpleProduct.getPrice());
        System.out.println("Специальный товар: " + simpleProduct.isSpecial());

        System.out.println("Название товара со скидкой: " + discountedProduct.getName());
        System.out.println("Цена товара со скидкой: " + discountedProduct.getPrice());
        System.out.println("Специальный товар: " + discountedProduct.isSpecial());

        System.out.println("Название товара с фиксированной ценой: " + fixedPriceProduct.getName());
        System.out.println("Цена товара с фиксированной ценой: " + fixedPriceProduct.getPrice());
        System.out.println("Специальный товар: " + fixedPriceProduct.isSpecial());

        System.out.println("Удаляем существующий продукт 'Перец': ");
        List<Product> removedProducts = basket.removeAllProductsByName("Перец");
        System.out.println("Удалённые товары:" );
        removedProducts.forEach(System.out::println);

        System.out.println("Текущее содержимое корзины после удаления:");
        basket.printContents();


        System.out.println("Удаляем несуществующий продукт 'Арбуз': ");
        List<Product> noRemovedProducts = basket.removeAllProductsByName("Арбуз");
        if (noRemovedProducts.isEmpty()) {
            System.out.println("Ничего не удалено, продукт не найден.");
        }

        System.out.println("Последнее содержимое корзины:");
        basket.printContents();
    }


}