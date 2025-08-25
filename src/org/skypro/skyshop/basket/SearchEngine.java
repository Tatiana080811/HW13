package org.skypro.skyshop.basket;
import org.skypro.skyshop.basket.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final Searchable[] elements;
    private int size;


    public SearchEngine(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Корзина не должна быть пустой.");
        }
        this.elements = new Searchable[capacity];
        this.size = 0;
    }
    public boolean add(Searchable element) {
        if (size < elements.length) {
            elements[size++] = element;
            return true;
        }
        return false;
    }
    public Searchable[] search(String query) {
        Searchable[] foundElements = new Searchable[5];
        int count = 0;

        for (int i = 0; i < size; i++) {
            Searchable currentElement = elements[i];
            if (currentElement.getSearchTerm().contains(query)) {
                foundElements[count++] = currentElement;
                if (count == 5) break;
            }
        }

        return foundElements;
    }
}
