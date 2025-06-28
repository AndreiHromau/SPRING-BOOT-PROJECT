package org.example.spring_project.models;

import java.util.*;

public class BookStorage { //класс списка книг

    private static Set<Book> books = new HashSet<>(); //лист книг

//добавление книжек + уник id строковый
    static {
        books.add(new Book(
                UUID.randomUUID().toString(),
                "Война и мир",
                "Лев Толстой",
                1200));
        books.add(new Book(
                UUID.randomUUID().toString(),
                "Бородино"
                , "Михаил Лермонтов",
                96));
    }

    public static Set<Book> getBooks() { //метод получить книгу
        return books;
    }
}

