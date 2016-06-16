package com.jf.service.serviceImpl;

import com.jf.dao.BlogMapper;
import com.jf.model.Blog;
import com.jf.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JF on 2016/6/16.
 */

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    public Blog getBlog(Blog blog) {
        return blogMapper.getBlog(blog);
    }

    public List<Blog> getBlogs(Blog blog) {
        return blogMapper.getBlogs(blog);
    }

    public List<Blog> getBlogAll() {
        return blogMapper.getBlogAll();
    }

    public void delete(Blog blog) {
        blogMapper.delete(blog);
    }

    public void update(Blog blog) {
        blogMapper.update(blog);
    }

    public void insert(Blog blog) {
        blogMapper.insert(blog);
    }
}
