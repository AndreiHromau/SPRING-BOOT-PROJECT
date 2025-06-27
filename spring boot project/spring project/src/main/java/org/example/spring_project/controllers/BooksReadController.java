package org.example.spring_project.controllers;

import org.example.spring_project.models.Book;
import org.example.spring_project.models.BookStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class BooksReadController {

    @GetMapping("/") //когда попали на морду сайта, будет вызов этого контроллера
    public String booklist(Model model) { //Через объект класса Model передаются данные из контроллера в шаблон
        model.addAttribute("books", BookStorage.getBooks()); //взяли из статического хранилища книжки и передали в model
        return "booklist"; //возврат с шаблоном
    }

    @GetMapping("/create-form") //будет вызов этого контроллера по ссылке
    public String createForm() {
        return "create-form";
    }

    @PostMapping("/create") //post для отправки данных на сервер
    public String create(Book book) {
        book.setId(UUID.randomUUID().toString()); //установим на новую книгу id рандом
        BookStorage.getBooks().add(book); //эту книжку туда добавляем
        return "redirect:/"; //после добавления книги нас вернет по адресу redirect, который напишем в HTML позже
    }

    @GetMapping("/delete/{id}") //спринг поймет {id} что это как параметр
    public String delete(@PathVariable("id") String id) { //передача книги через path параметр чтобы стринг понял из URL
        Book bookToDelete = BookStorage.getBooks().stream().
                filter(book -> book.getId().equals(id)). //равен id, который мы передали ищет такую книгу, итерируясь
                findFirst().
                orElseThrow(RuntimeException::new);
        BookStorage.getBooks().remove(bookToDelete);
        return "redirect:/"; //возвращаем на морду
    }

    @GetMapping("/edit-form/{id}")
    public String createForm(@PathVariable("id") String id, Model model) {
        Book bookToEdit = BookStorage.getBooks().stream().
                filter(book -> book.getId().equals(id)).
                findFirst().
                orElseThrow(RuntimeException::new);
        model.addAttribute("book", bookToEdit);
        return "edit-form"; //отсылаем на edit-form
    }

    @PostMapping("/update") //post для отправки данных на сервер
    public String update(Book book) {
        delete(book.getId()); //мы найдем эту книжку и просто удалим
        BookStorage.getBooks().add(book); //и заново добавим
        return "redirect:/";
    }

}
