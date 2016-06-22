package com.jf.service;

import com.jf.model.Reply;

import java.util.List;

/**
 * Created by JF on 2016/6/18.
 */
public interface ReplyService {

    void insert(Reply reply);

    void delete(Reply reply);

    void update(Reply reply);

    Reply getReply(Reply reply);

    List<Reply> getReplyAll(Reply reply);

    List<Reply> getReplySearch(Reply reply);

    List<Reply> getReplySearchString(String param);


}
