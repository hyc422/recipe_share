package org.iclass.mvc.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Member;

@Mapper
public interface MemberMapper {
	int register(Member member);
	Member login(Map<String,String> map);
	int idcheck(String id);
	int nickchk(String nickname);
}
