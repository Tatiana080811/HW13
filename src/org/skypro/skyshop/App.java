package org.skypro.skyshop;
import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.basket.SearchEngine;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.Searchable;
import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.exceptions.BestResultNotFound;

public class App {
    public static void main(String[] args) {
        List<Searchable> searchables = new ArrayList<>();
        searchables.add(new Product("Яблоко", 50));
        searchables.add(new Article("Яблоко", "Сезонное, зеленое, кислое"));


        try {
            String searchQuery = "Яблоко";
            Searchable bestMatch = SearchEngine.findBestMatch(searchables, searchQuery);
            System.out.println("Самый подходящий объект: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
        try {
            String searchQueryError = "Яблоко";
            Searchable bestMatch = SearchEngine.findBestMatch(searchables, searchQueryError);
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
        ProductBasket basket = new ProductBasket();

        Product simpleProduct = new DiscountedProduct.SimpleProduct("Простой персик", 50.0, 40);
        Product discountedProduct = new DiscountedProduct("Персик со скидкой", 100.0, 10);
        Product fixedPriceProduct = new FixPriceProduct("Персик с фиксированной ценой");

        DiscountedProduct.SimpleProduct apple = new DiscountedProduct.SimpleProduct("Яблоко", 50, -20);
        DiscountedProduct.SimpleProduct banana = new DiscountedProduct.SimpleProduct("Киви", 70, 80);
        DiscountedProduct.SimpleProduct orange = new DiscountedProduct.SimpleProduct("Апельсин", 80, 5);
        DiscountedProduct.SimpleProduct grapefruit = new DiscountedProduct.SimpleProduct("Грейпфрут", 100, 90);
        DiscountedProduct.SimpleProduct kiwi = new DiscountedProduct.SimpleProduct("Киви", 60, 15);
        DiscountedProduct.SimpleProduct melon = new DiscountedProduct.SimpleProduct("Дыня", 150, -20);

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
        System.out.println("Есть ли Яблоко в пустой корзине? " + basket.containsProductByName("Яблоко"));

        basket.addProduct(simpleProduct);
        basket.addProduct(discountedProduct);
        basket.addProduct(fixedPriceProduct);

        System.out.println("=== Содержимое корзины ===");
        basket.printContents();

        System.out.println("== Дополнительная проверка ==");
        System.out.println("Название обычного персика: " + simpleProduct.getName());
        System.out.println("Цена обычного персика: " + simpleProduct.getPrice());
        System.out.println("Является ли обычный товар специальным: " + simpleProduct.isSpecial());

        System.out.println("Название персика со скидкой: " + discountedProduct.getName());
        System.out.println("Цена персика со скидкой: " + discountedProduct.getPrice());
        System.out.println("Является ли товар со скидкой специальным: " + discountedProduct.isSpecial());

        System.out.println("Название персика с фиксированной ценой: " + fixedPriceProduct.getName());
        System.out.println("Цена персика с фиксированной ценой: " + fixedPriceProduct.getPrice());
        System.out.println("Является ли товар с фиксированной ценой специальным: " + fixedPriceProduct.isSpecial());
    }
}