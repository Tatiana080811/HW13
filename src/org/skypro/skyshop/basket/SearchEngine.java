package org.skypro.skyshop.basket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.basket.Searchable;

import java.util.*;

public class SearchEngine {
    private static Comparator<Searchable> articleComparator = new Comparator<>() {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lenCompare = Integer.compare(s1.getName().length(), s2.getName().length());

            if (lenCompare != 0) {
                return -lenCompare;
            }

            return s1.getName().compareTo(s2.getName());
        }
    };
    public static Set<Searchable> findAllMatches(Set<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Исходные данные для поиска пусты.");
        }
        Set<Searchable> results = new TreeSet<>(articleComparator);

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