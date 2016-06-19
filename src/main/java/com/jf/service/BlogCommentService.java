package com.jf.service;

import com.jf.model.BlogComment;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
public interface BlogCommentService {

    void insert(BlogComment blogComment);

    void delete(BlogComment blogComment);

    void update(BlogComment blogComment);

    List<BlogComment> getBlogCommentAll(BlogComment blogComment);

    BlogComment getBlogComment(BlogComment blogComment);

}
