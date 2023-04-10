package org.iclass.mvc.service;

import java.util.List;

import org.iclass.mvc.dao.IndexMapper;
import org.iclass.mvc.dto.Board;

import org.iclass.mvc.dto.Member;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IndexService {
	private final IndexMapper dao;
	
	public List<Board> viewcntSelect(){
		return dao.viewcntSelect();
	}
	public List<Board> cntSelect(){
		return dao.cntSelect();
	}
	public List<Board> regSelect(){
		return dao.regSelect();
	}

	public List<Member> memberAll(){
		return dao.memberAll();
	}
	public void updateM(Member vo) {
		 dao.updateM(vo);
	}
	public void deleteM(int idx) {
		dao.deleteM(idx);

	}
}
