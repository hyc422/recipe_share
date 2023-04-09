package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.UploadFile;
@Mapper
public interface UploadFileMapper {
	public int save(UploadFile file);
	public List<UploadFile> imgSelect(int boardNum);
	public UploadFile load(int idx);
	public int nextSeq();	
	public int boardNextSeq();	
	
	
	
}
