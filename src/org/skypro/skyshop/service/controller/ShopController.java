package org.skypro.skyshop.service.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.skypro.skyshop.service.StorageService;
import org.skypro.skyshop.service.model.search.product.Product;
import org.skypro.skyshop.service.model.search.product.article.Article;

import java.util.Collection;
@org.skypro.skyshop.service.controller.RestController
public class ShopController {
    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @org.skypro.skyshop.service.controller.GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllProducts();
    }

    @org.skypro.skyshop.service.controller.GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllArticles();
    }
    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }
}
