package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Board;

@Mapper
public interface BoardMapper {
	//01. 게시글 작성
	public int create(Board vo);
	//02. 게시글 상세보기
	public Board read(int idx);
	//03. 게시글 수정
	public int update(Board vo);
	//04. 게시글 삭제
	public void delete(int idx);
	//05. 게시글 전체 목록
	public List<Board> listAll();
	//06. 게시글 조회 증가 
	public void increaseViewcnt(int idx);
}
