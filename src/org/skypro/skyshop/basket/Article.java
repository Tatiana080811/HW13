package org.skypro.skyshop.basket;
import java.util.Objects;

public class Article implements Searchable {
    private  String name;
    private  String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Article)) return false;
        Article other = (Article) obj;
        return Objects.equals(name, other.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    @Override
    public String getSearchTerm() {
        return name + " " + content;
    }
    @Override
    public String getContentType() {
        return "ARTICLE";
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Статья: " + name + ". " + content;
    }
}
