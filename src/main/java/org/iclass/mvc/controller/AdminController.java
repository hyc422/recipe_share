package org.iclass.mvc.controller;

import java.time.LocalDate;

import org.iclass.mvc.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {
	
	private final SearchService service;
	
	@GetMapping("/adminPage")
	public String adminPage() {
		return "admin";
	}
	
	@GetMapping("/board_search")
	public String board_search(@RequestParam(defaultValue = "1") int page, Model model,String board_search,int a) {
		if(a == 0) {
			model.addAttribute("list", service.AllSearch(board_search, page).get("list"));
			model.addAttribute("paging", service.AllSearch(board_search, page).get("paging"));
		}else if(a == 1) {
			model.addAttribute("list", service.CagSearch(board_search, page).get("list"));
			model.addAttribute("paging", service.CagSearch(board_search, page).get("paging"));
		}else if(a == 2) {
			model.addAttribute("list", service.TitSearch(board_search, page).get("list"));
			model.addAttribute("paging", service.TitSearch(board_search, page).get("paging"));
		}else if(a == 3) {
			model.addAttribute("list", service.ContSearch(board_search, page).get("list"));
			model.addAttribute("paging", service.CagSearch(board_search, page).get("paging"));
		}
		log.info("board_search :{} == a : {}",board_search,a);
		model.addAttribute("today", LocalDate.now());	
		model.addAttribute("a", a);	
		model.addAttribute("board_search", board_search);	
	    return "admin";
	}
}
