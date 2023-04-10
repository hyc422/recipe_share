package org.iclass.mvc.controller;

import java.util.List;
import java.util.Map;

import org.iclass.mvc.dto.UploadFile;
import org.iclass.mvc.service.BoardService;
import org.iclass.mvc.service.CommentsService;
import org.iclass.mvc.service.ImgUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequiredArgsConstructor 
public class ImgUploadController {
	private final ImgUploadService service;
	private final BoardService service2;
	@Autowired
	ResourceLoader resourceLoader;
	
	@PostMapping("/image")                                                                   
	public ResponseEntity<?> imageUpload(@RequestParam("file") MultipartFile file) {
		try {
			UploadFile uploadFile = service.store(file);      
			return ResponseEntity.ok().body("/image/" + uploadFile.getUpidx());
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/image/{fileId}")                                                           
	public ResponseEntity<?> serveFile(@PathVariable int fileId){
		try {
			UploadFile uploadFile = service.load(fileId);
			log.info("file:{}",uploadFile.getFilePath());
			Resource resource = resourceLoader.getResource("file:" + uploadFile.getFilePath());
			return ResponseEntity.ok().body(resource);
			
		} catch(Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.badRequest().build();
		}
		
	}
}
