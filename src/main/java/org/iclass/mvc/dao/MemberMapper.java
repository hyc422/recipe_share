package org.iclass.mvc.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Member;

@Mapper
public interface MemberMapper {
	int insert(Member member);
	Member login(Map<String,String> map);
}
