package org.iclass.mvc.controller;


import java.util.List;
import java.util.Map;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Paging;
import org.iclass.mvc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor 
//@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	
	//레시피 게시판 자동 화면
//	@GetMapping("/list")
//	public String list() throws Exception{
//		//게시판 리스트 만들기 -> model 에 저장
//		
//		
//		
//		
//		
//		return "board/list";
//	}
	
	// 글 작성 화면
	@GetMapping("/write")
	public void write() {
	}
	
	
	// 게시판 글 저장
	@PostMapping("/write")
	public String write(Board vo){
//		log.info("recipe vo:{}",vo);
//		String message;
//		if(service.create(vo)==1)
//			message="글 등록 되었습니다.";
//		else
//			message="글 등록에 문제가 생겼습니다.";
//		reAttr.addFlashAttribute("message", message);
		int cnt = service.create(vo);
		
		return "redirect:recipeView";
		
	}
	//categorylist 페이지 호출
	@GetMapping("/list")
		public String categoryPaging(String Cate,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "0") int a,
	                             Model model) {
	    if (a==1) {
	    	model.addAttribute("list",service.getsubCateList(Cate, page).get("list"));
	    	model.addAttribute("paging", service.getsubCateList(Cate, page).get("paging"));
	    } else if(a==0){
	    	model.addAttribute("list", service.getCategoryList(Cate, page).get("list"));
	    	model.addAttribute("paging", service.getCategoryList(Cate, page).get("paging"));
	    }
	    model.addAttribute("a", a);
	    model.addAttribute("Cate", Cate);
	    
//	    return "list?Cate="+Cate+"&a="+a+"&page="+page;
	    return "list";
	}
	
	@GetMapping("/read")
	public String read(@ModelAttribute("page") int page, int idx, Model model,String Cate,int a) {
		model.addAttribute("vo", service.read(idx));
		model.addAttribute("a", a);
	    model.addAttribute("Cate", Cate);
	    model.addAttribute("page", page);
		return "read";
	}
	
}
	


