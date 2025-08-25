package org.skypro.skyshop.basket;

public class Article implements Searchable {
    private String articleName;
    private String articleTerm;

    @Override
    public String toString() {
        return "Article{" +
                "articleName='" + articleName + '\'' +
                ", articleText='" + articleTerm + '\'' +
                '}';


    }
    @Override
    public String getSearch(){
        return this.toString();
    }
    @Override
    public String getName(){
        return this.articleName;
    }
    @Override
    public void performSearch(){
        System.out.println("Выполнен поиск по статье: " + this.getSearchTerm());
    }
    @Override
    public String toString() {
        return this.articleName + ": " + this.articleTerm;

    }
    @Override
    public String getStringRepresentation(){
        return this.getName() + " - " + this.getContentType();
    }

}
