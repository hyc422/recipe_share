package org.iclass.mvc.controller;


import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Comments;
import org.iclass.mvc.service.BoardService;
import org.iclass.mvc.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor 
//@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	private final CommentsService ser;
	
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
	public String write(Board vo, String category){
//		log.info("recipe vo:{}",vo);
//		String message;
//		if(service.create(vo)==1)
//			message="글 등록 되었습니다.";
//		else
//			message="글 등록에 문제가 생겼습니다.";
//		reAttr.addFlashAttribute("message", message);
		 String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
		    String unicodeCategory = new String(encodedCategory.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
		    
		    service.create(vo);
		    return "redirect:/list?Cate=" + unicodeCategory + "&a=0&page=1";
		
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
	public String read(@ModelAttribute("page") int page, int idx, Model model,String Category,int a) {
//		int comments = ser.setCommentsCount(idx);
		model.addAttribute("vo", service.read(idx));
//		model.addAttribute("comments", comments);
		model.addAttribute("a", a);
	    model.addAttribute("Cate", Category);
	    model.addAttribute("page", page);
	    
	    List<Comments> cmtlist = ser.commentList(idx);
	    model.addAttribute("cmtlist", cmtlist);
	    
	    
	    Comments cnt = ser.setCommentsCount(idx);
		model.addAttribute("cnt", cnt);
	    return "read";
		
		
	}
	@PostMapping("/read")
	public String insertComment(@ModelAttribute("com") Comments vo,String Category,int a,int merf,Model model) {
	    ser.Commentsinsert(vo);
	    return "redirect:/read?idx=" + merf + "&Cate=" + Category + "&a=" + a + "&page=1";
	}
	@PostMapping("/update")
	public String update(Board vo, String Category, int a,int merf,Model model) {
	   int result= service.update(vo);
	   if (result > 0) {
		   model.addAttribute("msg", "게시물이 수정되었습니다.");
		   } else {
		   model.addAttribute("msg", "게시물 수정에 실패하였습니다.");
		   }
		   return "redirect:/read?idx=" + merf + "&Category=" + Category + "&a=" + a + "&page=1";
	}
	
}
	


