package com.Zynetic.BookStore.Application.controller;

import com.Zynetic.BookStore.Application.entity.Book;
import com.Zynetic.BookStore.Application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book create(@RequestBody Book book){
        return bookService.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/filter/author")
    public List<Book> filterByAuthor(@RequestParam String author) {
        return bookService.searchByAuthor(author);
    }

    @GetMapping("/filter/category")
    public List<Book> filterByCategory(@RequestParam String category) {
        return bookService.searchByCategory(category);
    }

    @GetMapping("/filter/rating")
    public List<Book> filterByRating(@RequestParam double minRating) {
        return bookService.searchByRating(minRating);
    }



}
