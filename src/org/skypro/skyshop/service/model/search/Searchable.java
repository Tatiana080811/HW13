package org.skypro.skyshop.service.model.search;
import java.util.UUID;


public interface Searchable {
    UUID getId();

    String getSearchTerm();
    String getContentType();
    String getName();




    public default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}


