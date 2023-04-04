package org.iclass.mvc.service;

import java.util.List;

import org.iclass.mvc.dao.CommentsMapper;
import org.iclass.mvc.dto.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsDaolmpl implements CommentsService {
    @Autowired
    private CommentsMapper dao;

    @Override
    public int Commentsinsert(Comments comments) {
        return dao.Commentsinsert(comments);
    }

    @Override
    public int CommentsDelete(int idx) {
        return dao.CommentsDelete(idx);
    }

    @Override
    public int setCommentsCount(int idx) {
        return dao.setCommentsCount(idx);
    }

    @Override
    public List<Comments> commentList(int idx) {
        return dao.commentList(idx);
    }

    @Override
    public int commentUpdate(Comments comment) {
        return 0;
    }
}