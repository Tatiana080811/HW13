package org.skypro.skyshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.skypro.skyshop.model.SearchResult;
import org.skypro.skyshop.model.Searchable;

@Service
public class SearchService {
    private final StorageService storageService;

    @Autowired
    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String pattern) {
        return storageService.getAllSearchables().stream()
                .filter(s -> s.getName().contains(pattern))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
