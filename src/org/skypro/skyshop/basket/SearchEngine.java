package org.skypro.skyshop.basket;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private static final Comparator<Searchable> ARTICLE_COMPARATOR = new Comparator<Searchable>() {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lenCompare = Integer.compare(s1.getName().length(), s2.getName().length());
            if (lenCompare != 0) {
                return -lenCompare; // длиннее идет первым
            }
            return s1.getName().compareTo(s2.getName()); // сортировка по имени
        }
    };

    public static Searchable findBestMatch(List<Searchable> searchables, String search) throws BestResultNotFound {
        if (searchables == null || searchables.isEmpty() || search == null || search.isEmpty()) {
            throw new BestResultNotFound("Источник данных для поиска пуст.");
        }
        List<Searchable> matches = new ArrayList<>();
        for (Searchable item : searchables) {
            if (item.getSearchTerm().contains(search)) {
                matches.add(item);
            }
        }
        if (matches.isEmpty()) {
            throw new BestResultNotFound("Не удалось найти ни одного результата для запроса: " + search);
        }
        matches.sort(ARTICLE_COMPARATOR);
        return matches.get(0);
    }
}





