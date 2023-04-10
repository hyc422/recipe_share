package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Member;


@Mapper
public interface IndexMapper {
	List<Board> viewcntSelect();
	List<Board> cntSelect();
	List<Board> regSelect();

	List<Member> memberAll(); 
	void updateM(Member vo);
	void deleteM(int idx);
}

