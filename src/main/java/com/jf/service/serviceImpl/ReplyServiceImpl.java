package com.jf.service.serviceImpl;

import com.jf.dao.ReplyMapper;
import com.jf.model.Reply;
import com.jf.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    public void insert(Reply reply) {
        replyMapper.insert(reply);
    }

    public void delete(Reply reply) {
        replyMapper.delete(reply);
    }

    public void update(Reply reply) {
        replyMapper.update(reply);
    }

    public Reply getReply(Reply reply) {
        return replyMapper.getReply(reply);
    }

    public List<Reply> getReplyAll(Reply reply) {
        return replyMapper.getReplyAll(reply);
    }
}
