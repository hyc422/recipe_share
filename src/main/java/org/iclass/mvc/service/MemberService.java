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

	// HYC#3 Mypage update
	public int update(Member dto) 
	{
		return dao.update(dto);
	}	// method end
}
