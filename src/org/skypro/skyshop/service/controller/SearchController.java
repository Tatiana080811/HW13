package org.skypro.skyshop.service.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.model.search.SearchResult;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<SearchResult> search(@RequestParam String pattern) {
        return searchService.search(pattern);
    }
}