package org.iclass.mvc.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.iclass.mvc.dao.BoardMapper;
import org.iclass.mvc.dto.Board;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardDaoImpl implements BoardService {
	
	SqlSession SqlSession;
	private BoardMapper dao;
	public BoardDaoImpl(BoardMapper dao) {
		this.dao=dao;
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
		return SqlSession.selectOne("board.selectByidx",idx);
	}
	
	//03. 게시글 수정
	@Override
	public int update(Board vo) {
		return SqlSession.update("board.Article",vo);
		
	}

	//04. 게시글 삭제
	@Override
	public void delete(int idx) {
		SqlSession.delete("board.deleteArticle", idx);
	}

	@Override
	public List<Board> listAll() {
		return SqlSession.selectList("board.selectAll");
	}

	@Override
	public void increaseViewcnt(int idx) {
		SqlSession.update("board.updateviewcnt", idx);
	}
	
	
	
	
	
}
