package org.example.spring_project.models;

import java.util.*;

public class BookStorage { //класс списка книг

    private static Set<Book> books = new HashSet<>(); //лист книг

//добавление книжек + уник id строковый
    static {
        books.add(new Book(
                UUID.randomUUID().toString(),
                "Учение Дона Хуана",
                "Карлос Кастанеда",
                400));
        books.add(new Book(
                UUID.randomUUID().toString(),
                "<Богатый Папа, Бедный Папа>"
                , "Роберт Киосаки",
                300));
    }

    public static Set<Book> getBooks() { //метод получить книгу
        return books;
    }
}

