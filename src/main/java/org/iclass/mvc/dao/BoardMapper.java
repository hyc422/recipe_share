package org.iclass.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
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
	public List<Board> listAll(Map<String, Integer> map);
	//06. 게시글 조회 증가 
	public void increaseViewcnt(int idx);
	int count();
	int getCategorycount(String category);
	int getsubCatecount(String subCate);
    // 9. 메인 카테고리별 게시글 목록 조회
    public List<Board> getsubCateList(Map<String, Object> map);
    // 10. 카테고리별 게시글 목록 조회
    public List<Board> getCategoryList(Map<String, Object> map);
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
	public int cntcomments(int idx);
}
