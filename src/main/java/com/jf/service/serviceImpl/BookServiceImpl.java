package com.jf.service.serviceImpl;

import com.jf.dao.BookTypeMapper;
import com.jf.model.Book;
import com.jf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by JF on 2016/6/7.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookTypeMapper bookTypeMapper;


    public void insert(Book book) {

    }

    public void update(Book book) {

    }

    public void delete(Book book) {

    }

    public Book getBook(Book book) {
        return null;
    }

    public Book getBookId(int bookId) {
        return null;
    }

    public List<Book> getBooks() {
        return null;
    }

    public List<Book> getBooksAll(Book book) {
        return null;
    }
}
