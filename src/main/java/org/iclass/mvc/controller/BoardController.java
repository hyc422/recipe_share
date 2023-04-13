package org.iclass.mvc.controller;


import java.io.IOException;
import java.lang.reflect.Member;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Comments;
import org.iclass.mvc.service.BoardService;
import org.iclass.mvc.service.CommentsService;
import org.iclass.mvc.service.IndexService;
import org.iclass.mvc.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor 
//@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	private final CommentsService ser;
	private final MemberService memberservice;
	private final IndexService Iservice;
	
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
	public String write(Board vo, String category, Model model, String subCate){
		 String CT=null;
		 int a = 0;
		    if(subCate != null) {
		    	 String encodedSubCate = URLEncoder.encode(subCate, StandardCharsets.UTF_8);
				 String unicodeSubCate = new String(encodedSubCate.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
				CT= unicodeSubCate;
				a=1;
		    }else {
		    	String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
			    String unicodeCategory = new String(encodedCategory.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
			    CT=unicodeCategory;
			    a=0;
		    }
		    service.create(vo);
		    return "redirect:/list?Cate=" + CT + "&a="+a+"&page=1";
		
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
	    model.addAttribute("Alist", Iservice.announcementList());
//	    return "list?Cate="+Cate+"&a="+a+"&page="+page;
	    return "list";
	}
	
	@GetMapping("/read")
	public String read(@ModelAttribute("page") int page, int idx, Model model,String Cate,int a) {
//		int comments = ser.setCommentsCount(idx);
		model.addAttribute("vo", service.read(idx));
//		model.addAttribute("comments", comments);
		model.addAttribute("a", a);
	    model.addAttribute("Cate", Cate);
	    model.addAttribute("page", page);
	    log.info("---------------------idx:{}",service.read(idx));
	    List<Comments> cmtlist = ser.commentList(idx);
	    model.addAttribute("cmtlist", cmtlist);
	    
	    service.increaseViewcnt(idx);
	    
	    Board viewcnt = service.SelectViewcnt(idx);
	    model.addAttribute("viewcnt", viewcnt);
	    
	    Comments cnt = ser.setCommentsCount(idx);
		model.addAttribute("cnt", cnt);
	    return "read";
		
		
	}
	@PostMapping("/read")
	public String insertComment(@ModelAttribute("com") Comments vo,String Category,int a,int merf, Model model) {
		log.info("vo{}",vo);
	    ser.Commentsinsert(vo);
	    return "redirect:/read?idx=" + merf + "&Cate=" + Category + "&a=" + a + "&page=1";
	}
	@PostMapping("/deleteread")
	public String readDelete(Model model, Board vo, int idx, String category, int a, int page) {
		String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
	    String unicodeCategory = new String(encodedCategory.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
		int delete= service.delete(idx);
		model.addAttribute("delete", delete);
	    return "redirect:/list?Cate=" + unicodeCategory + "&a="+a+"&page="+page;
	}
	@GetMapping("/readupdate")
	public String readupdate(Board vo ,int idx, int a, Model model,int page ,String Category) {
		model.addAttribute("board", service.read(idx));
		model.addAttribute("a", a);
	    model.addAttribute("Cate", Category);
	    model.addAttribute("page", page);
	    log.info("---------------------idx:{}",service.read(idx));
		return "readupdate";
		
	}
	@PostMapping("/readupdate")
	public String update(@RequestParam("pics") List<MultipartFile> pics,
	                     @ModelAttribute Board vo, 
	                     @RequestParam String Cate, 
	                     @RequestParam int a, 
	                     int idx,int page,
	                     Model model) throws IOException {
	    String encodedCategory = URLEncoder.encode(Cate, StandardCharsets.UTF_8);
	    String unicodeCategory = new String(encodedCategory.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
	    
	    service.update(vo);
	    return "redirect:/read?idx="+idx+"&page="+page+"&a="+a+"&Cate="+unicodeCategory;
	}
}
	


