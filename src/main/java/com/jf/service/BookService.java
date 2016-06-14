package com.jf.service;

import com.jf.model.Book;

import java.util.List;

/**
 * Created by JF on 2016/6/7.
 */
public interface BookService {

    void insert(Book book);

    void update(Book book);

    void delete(Book book);

    Book getBook(Book book);

    List<Book> getBooks();

    List<Book> getBooksAll(Book book);

    void insertRedis(Book book);

    void updateRedis(Book book);


}
