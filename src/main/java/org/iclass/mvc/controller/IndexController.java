package org.iclass.mvc.controller;

import java.time.LocalDate;

import org.iclass.mvc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class IndexController 
{
	private final IndexService service;

	@GetMapping({"/","index"})
	public String index(Model model) {
		model.addAttribute("viewcnt", service.viewcntSelect());
		model.addAttribute("cnt", service.cntSelect());
		model.addAttribute("reg", service.regSelect());
		model.addAttribute("today", LocalDate.now());	
		return "index";
	}
}	// Class end
