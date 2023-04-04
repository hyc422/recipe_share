package org.iclass.mvc.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.iclass.mvc.dto.Board;
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
		List<Board>viewcntList = service.viewcntSelect();
		List<Board>cntList = service.cntSelect();
		List<Board>regList = service.regSelect();
		int limit = 15;
		List<Board>viewcnt = viewcntList.stream().limit(limit).collect(Collectors.toList());
		List<Board>cnt = cntList.stream().limit(limit).collect(Collectors.toList());
		List<Board>reg = regList.stream().limit(limit).collect(Collectors.toList());
		model.addAttribute("viewcnt", viewcnt);
		model.addAttribute("cnt", cnt);
		model.addAttribute("reg", reg);
		model.addAttribute("today", LocalDate.now());	
		return "index";
	}
}	// Class end
