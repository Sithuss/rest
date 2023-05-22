package com.example.bookstoreapi.service;

import com.example.bookstoreapi.dao.BookDao;
import com.example.bookstoreapi.dao.CategoryDao;
import com.example.bookstoreapi.entity.Book;
import com.example.bookstoreapi.entity.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> findAllBooks() {
        return bookDao.findAll();
    }

    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public Book findBookById(int id) {
        return bookDao.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
