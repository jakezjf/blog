package com.jf.service;

import com.jf.model.Blog;

import java.util.List;

/**
 * Created by JF on 2016/6/16.
 */
public interface BlogService {

    Blog getBlog(Blog blog);

    List<Blog> getBlogs(Blog blog);

    List<Blog> getBlogAll();

    void delete(Blog blog);

    void update(Blog blog);

    void insert(Blog blog);

}
