package com.jf.service.serviceImpl;

import com.jf.dao.BlogTypeMapper;
import com.jf.model.BlogType;
import com.jf.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
@Service
@Transactional
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    public void insert(BlogType blogType) {
        blogTypeMapper.insertSelective(blogType);
    }

    public void delete(BlogType blogType) {
        blogTypeMapper.delete(blogType);
    }

    public void update(BlogType blogType) {
        blogTypeMapper.update(blogType);
    }

    public BlogType getBlogType(BlogType blogType) {
        return blogTypeMapper.getBlogType(blogType);
    }

    public List<BlogType> getBlogTypeAll(BlogType blogType) {
        return blogTypeMapper.getBlogTypeAll(blogType);
    }

    public String getBlogTypeName(Integer blogType) {
        return blogTypeMapper.getBlogTypeName(blogType);
    }
}
