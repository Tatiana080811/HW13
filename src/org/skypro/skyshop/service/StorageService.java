package org.skypro.skyshop.service;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
import java.util.Collection;
import org.skypro.skyshop.service.model.search.product.Product;
import org.skypro.skyshop.service.model.search.product.article.Article;
import org.skypro.skyshop.service.model.search.Searchable;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        this.articles = new HashMap<>();
        initializeTestData();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

        public Collection<Searchable> getAllSearchables () {
            List<Searchable> result = new ArrayList<>(products.size() + articles.size());
            result.addAll(products.values());
            result.addAll(articles.values());
            return result;
        }
        private void initializeTestData () {
            Product product1 = new Product("Яблоко", 50.0);
            Product product2 = new Product("Простой персик", 100.0);
            Product product3 = new Product("Киви", 150.0);

            products.put(product1.getId(), product1);
            products.put(product2.getId(), product2);
            products.put(product3.getId(), product3);

            Article article1 = new Article("Яблоко", "Описание яблока");
            Article article2 = new Article("Персик", "Описание перскиа");
            Article article3 = new Article("Киви", "Описание киви");

            articles.put(article1.getId(), article1);
            articles.put(article2.getId(), article2);
            articles.put(article3.getId(), article3);
        }
    }

