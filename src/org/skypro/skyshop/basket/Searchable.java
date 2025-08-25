package org.skypro.skyshop.basket;

public interface Searchable {
    String getSearchTerm();
    void setGetSearchTerm(String searchTerm);
    void performSearch();
    String getContentType();
    String getName();

    default String getStringRepresentation() {
        return this.getName() + " - " + this.getContentType();
    }

}
