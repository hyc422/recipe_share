package org.iclass.mvc.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.iclass.mvc.dao.BoardMapper;
import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Paging;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardDaoImpl implements BoardService {
	
	
	SqlSession SqlSession;
	 private SqlSessionFactory sqlSessionFactory;
	private BoardMapper dao;
	  public BoardDaoImpl(SqlSession sqlSession, BoardMapper dao) {
	        this.SqlSession = sqlSession;
	        this.dao = dao;
	    }
	
	//01. 게시글 작성
	@Override
	public int create(Board vo) {
		String path ="C:\\NYR\\ubload";
		StringBuilder filenames = new StringBuilder();	
		
		for(MultipartFile f:vo.getPics()) {
			if(f.getSize()!=0) {
				String ofilename = f.getOriginalFilename();		
				String postfix = ofilename.substring(ofilename.lastIndexOf("."));
				StringBuilder newfile = new StringBuilder("gallery_")
						.append(UUID.randomUUID().toString().substring(0,8)).append(postfix);
				File file = new File(path + "\\"+newfile);	
				try {
					f.transferTo(file);
					filenames.append(newfile).append(",");	//db테이블에 들어갈 파일명
				} catch (IOException e) {	}
			}
		}	
		vo.setFilename(filenames.toString());
		return dao.create(vo);
	}

	//02. 게시글 상세보기 조회
	@Override
	public Board read(int idx) {
		return dao.read(idx);
	}
	
	//03. 게시글 수정
	@Override
	public int update(Board vo) {
		String path ="C:\\NYR\\ubload";
		StringBuilder filenames = new StringBuilder();	
		
		for(MultipartFile f:vo.getPics()) {
			if(f.getSize()!=0) {
				String ofilename = f.getOriginalFilename();		
				String postfix = ofilename.substring(ofilename.lastIndexOf("."));
				StringBuilder newfile = new StringBuilder("gallery_")
						.append(UUID.randomUUID().toString().substring(0,8)).append(postfix);
				File file = new File(path + "\\"+newfile);	
				try {
					f.transferTo(file);
					filenames.append(newfile).append(",");	//db테이블에 들어갈 파일명
				} catch (IOException e) {	}
			}
		}	
		vo.setFilename(filenames.toString());
		return dao.update(vo);
		
	}

	//04. 게시글 삭제
	@Override
	public int delete(int idx) {
		return dao.delete(idx);
	}
	//05. 카테고리별 게시글 목록 조회
	public Map<String,Object> getCategoryList(String category, int page) {
		  	int pageSize = 10;
		    int totalCount = dao.getCategorycount(category);
		    Paging paging = new Paging(page, totalCount, pageSize);

		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("category", category);
		    map.put("start", paging.getStartNo());
		    map.put("end", paging.getEndNo());

		    List<Board> list = dao.getCategoryList(map);
		    Map<String, Object> result = new HashMap<String, Object>();
		    result.put("paging", paging);
		    result.put("list", list);
		    return result;
		}

	// 메인 카테고리별 게시글 목록 조회
	public Map<String, Object> getsubCateList(String subCate,int page){
		int pageSize = 10;
		int totalCount = dao.getsubCatecount(subCate);
		
		Paging paging = new Paging(page, totalCount, pageSize);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("subCate", subCate);
		map.put("start", paging.getStartNo());
		map.put("end", paging.getEndNo());
		
		List<Board> list = dao.getsubCateList(map);
		Map<String,Object> result = new HashMap<String, Object>();
		  result.put("paging", paging);
		  result.put("list", list);
	        return result;
	}
	//06. 게시글 조회수 증가
	@Override
	public int increaseViewcnt(int idx) {
		return dao.increaseViewcnt(idx);
	}

	@Override
	public Board cntcomments(int idx) {
		int cnt = dao.cntcomments(idx);
		Board board = new Board();
		board.setIdx(cnt);
		return board;
	}

	@Override
	public Board selectByIdx(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board SelectViewcnt(int idx) {
		return dao.SelectViewcnt(idx);
	}
	
	
}
