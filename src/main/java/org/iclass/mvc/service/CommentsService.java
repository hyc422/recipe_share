package org.iclass.mvc.service;

import java.util.List;

import org.iclass.mvc.dto.Comments;
import org.springframework.stereotype.Service;

@Service
public interface CommentsService{
	 int Commentsinsert(Comments comments);
	    int CommentsDelete(int idx);
	    Comments setCommentsCount(int idx);
	    List<Comments> commentList(int idx);
	    int commentUpdate(Comments comment);
	    
	}