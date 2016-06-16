package com.jf.service;

import com.jf.common.page.PagedResult;
import com.jf.model.BookType;

import java.util.List;

/**
 * Created by JF on 2016/6/8.
 */
public interface BookTypeService {

    void insert(BookType bookType);

    void delete(BookType bookType);

    void update(BookType bookType);

    List<BookType> getBookTypeList(BookType bookType);

    PagedResult<BookType> getBookTypes(BookType bookType,Integer pageNo,Integer pageSize);

    BookType getBookType(BookType bookType);

    String getBookTypeName(Integer bookType);

}
