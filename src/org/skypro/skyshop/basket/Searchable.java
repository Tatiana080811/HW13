package org.skypro.skyshop.basket;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();

    public default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}
