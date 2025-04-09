package com.Zynetic.BookStore.Application.service;

import com.Zynetic.BookStore.Application.entity.Book;
import com.Zynetic.BookStore.Application.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book save (Book book){
        return bookRepo.save(book);
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Optional<Book> findById(int id) {
        return bookRepo.findById(id);
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }

    public Book update(int id, Book book) {
        book.setId(id);
        return bookRepo.save(book);
    }

    public List<Book> searchByTitle(String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchByAuthor(String author) {
        return bookRepo.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> searchByCategory(String category) {
        return bookRepo.findByCategoryContainingIgnoreCase(category);
    }

    public List<Book> searchByRating(Double rating) {
        return bookRepo.findByRatingGreaterThanEqual(rating);
    }


}
