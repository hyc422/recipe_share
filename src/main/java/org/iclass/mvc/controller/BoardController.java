package org.iclass.mvc.controller;


import java.util.List;
import java.util.Map;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Paging;
import org.iclass.mvc.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor 
public class BoardController {
	private final BoardService service;
	
	//레시피 게시판 자동 화면
	@GetMapping("recipeView")
	public void recipeView() throws Exception{
		log.info("recipeView");
	}
	
	// 게시판 글 작성
	@PostMapping("recipeView")
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
		@GetMapping("/mainCategory")
	    public String categoryPaging(@PathVariable String category,
	                                 @PathVariable String mainCategory,
	                                 @RequestParam(defaultValue = "1") int page,
	                                 Model model) {
	        Map<String, Object> resultMap = service.getCategoryList(category, mainCategory, page);
	        Paging paging = (Paging) resultMap.get("paging");
	        List<Board> list = (List<Board>) resultMap.get("list");

	        model.addAttribute("list", list);
	        model.addAttribute("paging", paging);
	        model.addAttribute("category", category);
	        model.addAttribute("mainCategory", mainCategory);

	        return "category";
	    }
}
//	ddd


