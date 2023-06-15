package org.iclass.mvc.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.TopSelect;
import org.iclass.mvc.service.ImgUploadService;
import org.iclass.mvc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController 
{
	private final IndexService service;
	private final ImgUploadService service2;

	@GetMapping({"/","index"})
	public String index(Model model) {
		
		List<Board>viewcntList = service.viewcntSelect();
		List<Board>cntList = service.cntSelect();
		List<Board>regList = service.regSelect();
		List<TopSelect>TopSelectList = service.TopSelect();
//		int boardNum=viewcntList.get(0).getIdx();
//		List<UploadFile>imgSelect = service2.imgSelect(boardNum);
//		log.info("가장 높은 조회수--{}",boardNum);
//		log.info("가장 높은 조회수 사진--{}",imgSelect);
//		log.info("가장 높은 조회수 사진idx--{}",imgSelect.get(0).getIdx());
		int limit = 15;
		int limit2 = 5;
		List<Board>viewcnt = viewcntList.stream().limit(limit).collect(Collectors.toList());
		List<TopSelect>TopSelect = TopSelectList.stream().limit(limit2).collect(Collectors.toList());
		List<Board>cnt = cntList.stream().limit(limit).collect(Collectors.toList());
		List<Board>reg = regList.stream().limit(limit).collect(Collectors.toList());
		model.addAttribute("viewcnt", viewcnt);
		model.addAttribute("Top", TopSelect);
		model.addAttribute("cnt", cnt);
		model.addAttribute("reg", reg);
//		model.addAttribute("imgView", imgSelect.get(0).getSaveFileName());
		model.addAttribute("today", LocalDate.now());	
		return "index";
	}
}	// Class end
