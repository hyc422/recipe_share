package org.iclass.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.Board;

@Mapper
public interface SearchMapper {
	public List<Board>AllSearch(Map<String, Object>map);
	public List<Board>TitSearch(Map<String, Object>map);
	public List<Board>ContSearch(Map<String, Object>map);
	public List<Board>CagSearch(Map<String, Object>map);
	public int AllCount(String search);
	public int CagCount(String search);
	public int TitCount(String search);
	public int ContCount(String search);
}
