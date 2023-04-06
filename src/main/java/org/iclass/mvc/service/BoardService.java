package org.iclass.mvc.service;

import java.util.List;
import java.util.Map;

import org.iclass.mvc.dto.Board;

public interface BoardService {
	
	//01. 게시글 작성
	public int create(Board vo);
	//02. 게시글 상세보기
	public Board read(int idx);
	//03. 게시글 수정
	public int update(Board vo);
	//04. 게시글 삭제
	public int delete(int idx);
	//06. 게시글 조회 증가 
	public void increaseViewcnt(int idx);
    // 9. 메인 카테고리별 게시글 목록 조회
    public Map<String, Object> getsubCateList(String subCate, int page);
	public Map<String, Object> getCategoryList(String category, int page);
	public Board cntcomments(int idx);
	public Board selectByIdx(int idx);
}
