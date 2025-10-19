package org.skypro.skyshop.basket;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private static final Comparator<Searchable> ARTICLE_COMPARATOR = new Comparator<Searchable>() {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lenCompare = Integer.compare(s1.getName().length(), s2.getName().length());
            if (lenCompare != 0) {
                return -lenCompare;
            }
            return s1.getName().compareTo(s2.getName());
        }
    };

    public static Searchable findBestMatch(List<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Источник данных для поиска пуст.");
        }
        Set<Searchable> matchingResults = searchables.stream()
                .filter(item -> item.getSearchTerm().contains(search))
                .collect(Collectors.toCollection(() -> new TreeSet<>(ARTICLE_COMPARATOR)));

        if (matchingResults.isEmpty()) {
            throw new BestResultNotFound("Не удалось найти ни одного результата для запроса: " + search);
        }

        return matchingResults.iterator().next();
    }
}







