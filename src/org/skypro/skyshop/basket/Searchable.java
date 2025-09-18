package org.skypro.skyshop.basket;

public interface Searchable {
    String getSearchTerm();      // Термин для поиска
    String getContentType();     // Тип содержимого (например, PRODUCT или ARTICLE)
    String getName();            // Имя элемента

    public default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
