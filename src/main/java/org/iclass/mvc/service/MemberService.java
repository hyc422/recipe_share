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
	
  // CJW#2 Login
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

	// HYC#3 Mypage
	public int update(Member dto) 
	{
		return dao.update(dto);
	}	// method end
	
	public int chgPw(Map<String, String> map)
	{
		return dao.pwChg(map);
	}	// method end
}
