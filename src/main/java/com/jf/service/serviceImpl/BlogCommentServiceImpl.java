package com.jf.service.serviceImpl;

import com.jf.dao.BlogCommentMapper;
import com.jf.model.BlogComment;
import com.jf.service.BlogCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
@Service
@Transactional
public class BlogCommentServiceImpl implements BlogCommentService {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    public void insert(BlogComment blogComment) {
        blogCommentMapper.insertSelective(blogComment);
    }

    public void delete(BlogComment blogComment) {
        blogCommentMapper.delete(blogComment);
    }

    public void update(BlogComment blogComment) {
        blogCommentMapper.update(blogComment);
    }

    public List<BlogComment> getBlogCommentAll(BlogComment blogComment) {
        return blogCommentMapper.getBlogCommentAll(blogComment);
    }

    public BlogComment getBlogComment(BlogComment blogComment) {
        return blogCommentMapper.getBlogComment(blogComment);
    }
}
