package org.example.spring_project.models;

public class Book { //наша model

    private String id;
    private String name;
    private String author;
    private int pages;

    public Book() { //конструктор
    }

    public Book(String id, String name, String author, int pages) { //конструктор
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
