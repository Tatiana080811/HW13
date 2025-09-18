package org.skypro.skyshop.basket;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.basket.Searchable;

import java.util.List;

public class SearchEngine {
    public static Searchable findBestMatch(List<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Исходные данные для поиска пусты.");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            String term = item.getSearchTerm();
            int count = countSubstrings(term, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не удалось найти лучший результат для запроса: " + search);
        }

        return bestMatch;
    }

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