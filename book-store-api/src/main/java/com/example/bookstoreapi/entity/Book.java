package com.example.bookstoreapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private double price;
    @Column(name = "year_published")
    private LocalDate yearPublished;
    private String publisher;
    @Column(name = "image_url")
    private String imgUrl;
    @Column(name = "author_name")
    private String authorName;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    public Book(String title, double price, LocalDate yearPublished, String publisher, String imgUrl,
                String authorName) {
        this.title = title;
        this.price = price;
        this.yearPublished = yearPublished;
        this.publisher = publisher;
        this.imgUrl = imgUrl;
        this.authorName=authorName;
    }

    public Book(){

    }
}
