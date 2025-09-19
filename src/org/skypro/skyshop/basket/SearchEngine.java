package org.skypro.skyshop.basket;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.basket.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    public static List<Searchable> findAllMatches(List<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Исходные данные для поиска пусты.");
        }
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {
            String term = item.getSearchTerm();
            if (term.contains(search)) {
                results.add(item);
            }
        }

        if (results.isEmpty()) {
            throw new BestResultNotFound("Не удалось найти ни одного результата для запроса: " + search);
        }

        return results;
    }

    // Методы вспомогательные остаются прежними
    private static int countSubstrings(String text, String substring) {
        int count = 0;
        int pos = 0;

        while ((pos = text.indexOf(substring, pos)) != -1) {
            count++;
            pos += substring.length();
        }

        return count;
    }
}


