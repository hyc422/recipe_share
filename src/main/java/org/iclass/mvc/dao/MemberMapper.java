package org.iclass.mvc.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Member;

@Mapper
public interface MemberMapper {
  // CJW#2 login
	int register(Member member);
	Member login(Map<String,String> map);
	int idcheck(String email);
	int nickchk(String nickname);
	// HYC#3 mypage
	int update(Member dto);
	int pwChg(Map<String,String> map);

}
