package org.iclass.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.mvc.dao.SearchMapper;
import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Paging;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class SearchService {
	private final SearchMapper dao;
	
	public Map<String,Object>AllSearch(String search,int page){
				int pageSize=2;		
				int totalCount = dao.AllCount(search);
				
				Paging paging = new Paging(page, totalCount, pageSize);
				
				Map<String,Object> map = new HashMap<>();
				map.put("search",search);
				map.put("start",paging.getStartNo());
				map.put("end",paging.getEndNo());
				
				List<Board> list = dao.AllSearch(map);
				
				Map<String,Object> result = new HashMap<>(); 
				result.put("paging", paging);
				result.put("list", list);
				
				return result;
	}
	public Map<String,Object>TitSearch(String search,int page){
				int pageSize=5;		//pageSize 를 15 또는 10으로 변경해서 실행해 봅시다.
				int totalCount = dao.TitCount(search);
				
				Paging paging = new Paging(page, totalCount, pageSize);
				Map<String,Object> map = new HashMap<>();
				map.put("search",search);
				map.put("start",paging.getStartNo());
				map.put("end",paging.getEndNo());
				
				List<Board> list = dao.TitSearch(map);
				
				Map<String,Object> result = new HashMap<>(); 
				result.put("paging", paging);
				result.put("list", list);
				
				return result;
	}
	public Map<String,Object>ContSearch(String search,int page){
				int pageSize=5;		//pageSize 를 15 또는 10으로 변경해서 실행해 봅시다.
				int totalCount = dao.ContCount(search);
				
				Paging paging = new Paging(page, totalCount, pageSize);
				
				Map<String,Object> map = new HashMap<>();
				map.put("search",search);
				map.put("start",paging.getStartNo());
				map.put("end",paging.getEndNo());
				
				List<Board> list = dao.ContSearch(map);
				
				Map<String,Object> result = new HashMap<>(); 
				result.put("paging", paging);
				result.put("list", list);
				
				return result;
	}
	public Map<String,Object>CagSearch(String search,int page){
				
				int pageSize=5;		//pageSize 를 15 또는 10으로 변경해서 실행해 봅시다.
				int totalCount = dao.CagCount(search);
				
				Paging paging = new Paging(page, totalCount, pageSize);
				
				Map<String,Object> map = new HashMap<>();
				map.put("search",search);
				map.put("start",paging.getStartNo());
				map.put("end",paging.getEndNo());
				
				List<Board> list = dao.ContSearch(map);
				
				Map<String,Object> result = new HashMap<>(); 
				result.put("paging", paging);
				result.put("list", list);
				
				return result;
	}
}
