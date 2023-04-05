package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Comments;

@Mapper
public interface CommentsMapper {
	
	//댓글 작성
	  public int Commentsinsert(Comments comments);
	  	//댓글 삭제
	    public int CommentsDelete(int idx);
	    //댓글 갯수
	    public int setCommentsCount(int idx);
	   //댓글 목록
	    public List<Comments> commentList(int idx);
	    //댓글 수정
	    public int commentUpdate(Comments comment);
	    
	
}
