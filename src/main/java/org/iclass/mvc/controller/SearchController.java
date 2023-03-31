package org.iclass.mvc.controller;

import java.util.List;

import org.iclass.mvc.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
	
	@GetMapping("/search")
	public String search(@RequestParam("q") String query, Model model) {
	    List<String> results = SearchService.search(query);
	    model.addAttribute("searchTerm", query);
	    model.addAttribute("results", results);
	    return "search";
	}
}
