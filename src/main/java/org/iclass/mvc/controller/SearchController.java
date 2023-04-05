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
public class SearchController {
	
	private final SearchService service;
	
	@GetMapping("/search")
	public String search(@RequestParam(defaultValue = "1") int page, Model model,
			 @RequestParam(name = "search", required = false, defaultValue = "")String search,
			int a) {
		if(a == 0) {
			model.addAttribute("list", service.AllSearch(search, page).get("list"));
			model.addAttribute("paging", service.AllSearch(search, page).get("paging"));
		}else if(a == 1) {
			model.addAttribute("list", service.CagSearch(search, page).get("list"));
			model.addAttribute("paging", service.CagSearch(search, page).get("paging"));
		}else if(a == 2) {
			model.addAttribute("list", service.TitSearch(search, page).get("list"));
			model.addAttribute("paging", service.TitSearch(search, page).get("paging"));
		}else if(a == 3) {
			model.addAttribute("list", service.ContSearch(search, page).get("list"));
			model.addAttribute("paging", service.ContSearch(search, page).get("paging"));
		}
		log.info("Search :{} == a : {}",search,a);
		model.addAttribute("today", LocalDate.now());	
		model.addAttribute("a", a);	
		model.addAttribute("search", search);	
	    return "search";
	}
}
