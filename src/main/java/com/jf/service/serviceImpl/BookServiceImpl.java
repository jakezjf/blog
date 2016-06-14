package com.jf.service.serviceImpl;

import com.jf.dao.BookMapper;
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
    private BookMapper bookMapper;

    public void insert(Book book) {
        bookMapper.insert(book);
    }

    public void update(Book book) {
        bookMapper.update(book);
    }

    public void delete(Book book) {
        bookMapper.delete(book);
    }

    public Book getBook(Book book) {
        return bookMapper.getBook(book);
    }

    public List<Book> getBooks() {
        return bookMapper.getBooks();
    }

    public List<Book> getBooksAll(Book book) {
        return bookMapper.getBookAll(book);
    }

    public void insertRedis(Book book) {

    }

    public void updateRedis(Book book) {

    }
}
