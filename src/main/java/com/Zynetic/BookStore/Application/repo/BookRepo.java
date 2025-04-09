package com.Zynetic.BookStore.Application.repo;

import com.Zynetic.BookStore.Application.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends MongoRepository<Book, Integer> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByCategoryContainingIgnoreCase(String category);
    List<Book> findByRatingGreaterThanEqual(double rating);
    List<Book> findByTitleContainingIgnoreCase(String title);
}
