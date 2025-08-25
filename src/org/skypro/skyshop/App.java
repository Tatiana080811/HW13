package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.FixPriceProduct;
import org.skypro.skyshop.basket.Searchable;
import org.skypro.skyshop.basket.Article;
import org.skypro.skyshop.basket.SearchEngine;


public class App {

    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product simpleProduct = new DiscountedProduct.SimpleProduct("Простой персик", 50.0);
        Product discountedProduct = new DiscountedProduct("Персик со скидкой", 100.0, 20); // скидка 20%
        Product fixedPriceProduct = new FixPriceProduct("Персик с фиксированной ценой");

        DiscountedProduct.SimpleProduct apple = new DiscountedProduct.SimpleProduct("Яблоко", 50);
        DiscountedProduct.SimpleProduct banana = new DiscountedProduct.SimpleProduct("Банан", 70);
        DiscountedProduct.SimpleProduct orange = new DiscountedProduct.SimpleProduct("Апельсин", 80);
        DiscountedProduct.SimpleProduct grapefruit = new DiscountedProduct.SimpleProduct("Грейпфрут", 100);
        DiscountedProduct.SimpleProduct kiwi = new DiscountedProduct.SimpleProduct("Киви", 60);
        DiscountedProduct.SimpleProduct melon = new DiscountedProduct.SimpleProduct("Дыня", 150);

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

    public class TestSearchEngine {
        public static void main(String[] args) {

            Searchable product1 = new Product("Зеленый банан");
            Searchable product2 = new Product("Банан по уценке");
            Searchable productBasket1 = new ProductBasket("Корзина зеленая");
            Searchable productBasket2 = new ProductBasket("Корзина красная");

            Searchable article1 = new Article("Java Performance Optimization", "Boosting performance of Java applications");
            Searchable article2 = new Article("Best Practices for Mobile Development", "Guidelines for mobile app development");

            SearchEngine engine = new SearchEngine(10);

            engine.add(product1);
            engine.add(product2);
            engine.add(productBasket1);
            engine.add(productBasket2);
            engine.add(article1);
            engine.add(article2);

            testSearch(engine, "банан");
            testSearch(engine, "Корзина");
            testSearch(engine, "Java");
            testSearch(engine, "Best");


            private void testSearch (SearchEngine engine, String query) {
                System.out.println("Поиск по запросу '" + query + " ");
                Searchable[] results = engine.search(query);
                if (results.length > 0) {
                    for (Searchable result : results) {
                        if (result != null) {
                            System.out.println(result.getStringRepresentation());
                        }
                    }
                } else {
                    System.out.println("Ничего не найдено.");
                }
            }
        }
    }
}