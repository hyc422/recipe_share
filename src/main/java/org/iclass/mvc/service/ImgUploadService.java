package org.iclass.mvc.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

import org.iclass.mvc.dao.IndexMapper;
import org.iclass.mvc.dao.UploadFileMapper;
import org.iclass.mvc.dto.UploadFile;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImgUploadService {
	private final UploadFileMapper dao;
	
	public UploadFile store(MultipartFile file) {
		String path ="C:\\NYR\\ubload";
		String saveFileName;
		UploadFile saveFile = null;
		try {
			
			saveFileName = fileSave(path, file);
			saveFile = new UploadFile();
			saveFile.setUpidx(dao.nextSeq());
			saveFile.setBoardNum(dao.boardNextSeq());
			saveFile.setFileName(file.getOriginalFilename());
			saveFile.setSaveFileName(saveFileName);
			saveFile.setFilePath(path.replace(File.separatorChar, '/') +'/' + saveFileName);
			dao.save(saveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}           
		return saveFile;
	}

	public UploadFile load(int idx) {
		return dao.load(idx);
	}
	
	private String fileSave(String path, MultipartFile file) throws IOException {
		path ="C:\\NYR\\ubload";
		File uploadDir = new File(path);
		
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		// saveFileName 생성
		UUID uuid = UUID.randomUUID();
		String saveFileName = uuid.toString() + file.getOriginalFilename();
		File saveFile = new File(path, saveFileName);
		FileCopyUtils.copy(file.getBytes(), saveFile);
		
		return saveFileName;
	}
	public List<UploadFile> imgSelect(int boardNum) {
		return dao.imgSelect(boardNum);
	};
}
