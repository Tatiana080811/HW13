package org.skypro.skyshop.basket;

import java.util.Comparator;

public class ArticleComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lenCompare = Integer.compare(s1.getName().length(), s2.getName().length());
        if (lenCompare != 0) {
            return -lenCompare; // Сортируем по уменьшению длины
        }
        return s1.getName().compareTo(s2.getName()); // Стандартное сравнение имен
    }
}
