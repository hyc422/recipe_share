package org.iclass.mvc.service;

import java.util.HashMap;
import java.util.Map;

import org.iclass.mvc.dao.MemberMapper;
import org.iclass.mvc.dto.Member;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberMapper dao;
	
	public Member login(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		return dao.login(map);
	}
	public int register(Member vo) {
		
		return dao.register(vo);
	}
	public int idcheck(String id) {
		return dao.idcheck(id);
	}
	public int nickchk(String nickname) {
		return dao.nickchk(nickname);
	}
}
