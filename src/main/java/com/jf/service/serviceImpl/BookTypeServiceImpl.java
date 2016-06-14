package com.jf.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.jf.common.page.BeanUtil;
import com.jf.common.page.PagedResult;
import com.jf.dao.BookTypeMapper;
import com.jf.model.BookType;
import com.jf.service.BookTypeService;
import com.jf.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JF on 2016/6/8.
 */
@Service
@Transactional
public class BookTypeServiceImpl implements BookTypeService{

    @Autowired
    private BookTypeMapper bookTypeMapper;

    public void insert(BookType bookType) {
        bookTypeMapper.insertSelective(bookType);
    }

    public void delete(BookType bookType) {
        bookTypeMapper.delete(bookType);
    }

    public void update(BookType bookType) {
        bookTypeMapper.update(bookType);
    }

    public List<BookType> getBookTypeList(BookType bookType) {
        return bookTypeMapper.getBookTypes(bookType);
    }

    public PagedResult<BookType> getBookTypes(BookType bookType,Integer pageNo,Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return BeanUtil.toPagedResult(bookTypeMapper.getPageBookType(bookType));
    }
}
