package org.skypro.skyshop.service.model.search.product;
import java.util.Objects;
import org.skypro.skyshop.service.model.search.Searchable;
import java.util.UUID;

public class Product implements Searchable {
    protected final String name;
    private final double basePrice;
    protected final UUID id;

    public Product(String name, double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равной 0");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустой строкой");
        }
        this.name = name;
        this.basePrice = basePrice;
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId(){
        return id;
    }
    @JsonIgnore
    public String getSearchTerm() {
        return name;
    }

    @JsonIgnore
    public String getContentType() {
        return "PRODUCT";
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return "Продукт: " + this.getName();
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        return basePrice;
    }

    public boolean isSpecial() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return Objects.equals(this.name, other.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}
