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
	public Member login(String email, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("password", password);
		return dao.login(map);
	}
	
	public String findpwd(Map<String, String> map) {
		return dao.findpwd(map);
	}
	public String findem(Map<String, String> map) {
		return dao.findem(map);
	}
  public int register(Member vo) {
		return dao.register(vo);
	}
  
	public int emcheck(String email) {
		return dao.emcheck(email);
	}
	public int nickchk(String nickname) {
		return dao.nickchk(nickname);
	}

	// HYC#3 Mypage
	public int update(Member dto) 
	{
		return dao.update(dto);
	}	// method end
	
	public int chgPw(String email, String password)
	{
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("password", password);
		
		return dao.chgPw(map);
	}	// method end
	
	public Member selectOne(String email)
	{
		return dao.selectOne(email);
	}	// method end
}
