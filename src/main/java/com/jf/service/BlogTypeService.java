package com.jf.service;

import com.jf.model.BlogType;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
public interface BlogTypeService {

    void insert(BlogType blogType);

    void delete(BlogType blogType);

    void update(BlogType blogType);

    BlogType getBlogType(BlogType blogType);

    List<BlogType> getBlogTypeAll(BlogType blogType);

    String getBlogTypeName(Integer blogType);

}
