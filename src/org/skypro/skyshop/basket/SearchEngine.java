package org.skypro.skyshop.basket;

import org.skypro.skyshop.basket.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private Searchable[] elements;
    private int size;

    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер корзины должен быть положительным значением.");
        }
        this.elements = new Searchable[capacity];
        this.size = 0;
    }

    // Метод добавления элемента в корзину
    public boolean add(Searchable element) {
        if (size < elements.length) {
            elements[size++] = element;
            return true;
        }
        return false;
    }

    // Метод поиска по элементам
    public Searchable[] search(String query) {
        List<Searchable> foundElements = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Searchable currentElement = elements[i];
            if (currentElement.getSearchTerm().contains(query)) {
                foundElements.add(currentElement);
                if (foundElements.size() == 5) break;
            }
        }

        return foundElements.toArray(new Searchable[0]);
    }
}