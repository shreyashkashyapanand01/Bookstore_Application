package com.Zynetic.BookStore.Application.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
    @Id()
    private int id;

    private String title;
    private String author;
    private String category;
    private double price;
    private double rating;
    private String publishedDate;
}
