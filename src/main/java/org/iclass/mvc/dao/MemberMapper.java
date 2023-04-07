package org.iclass.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Member;

@Mapper
public interface MemberMapper 
{
  // CJW#2 login
	int register(Member member);
	Member login(Map<String,String> map);
	int emcheck(String email);
	int nickchk(String nickname);
	String findem(Map<String, String> map);
	String findpwd(Map<String, String> map);
	// HYC#3 mypage
	int update(Member dto);
	int pwChg(Map<String,String> map);
}
