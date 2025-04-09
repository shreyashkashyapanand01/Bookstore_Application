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
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author,
                                  @RequestParam(required = false) String category,
                                  @RequestParam(required = false) Double rating) {
        if (title != null) {
            return bookService.searchByTitle(title);
        }
        if (author != null) {
            return bookService.searchByAuthor(author);
        }
        if (category != null) {
            return bookService.searchByCategory(category);
        }
        if (rating != null) {
            return bookService.searchByRating(rating);
        }
        return bookService.findAll();
    }


}
