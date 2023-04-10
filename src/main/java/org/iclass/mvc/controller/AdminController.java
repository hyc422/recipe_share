package org.iclass.mvc.controller;



import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {
	
	private final IndexService ser;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("member", ser.memberAll());
		
		return "admin";
	}
	
	@GetMapping("/updateM")
	public String updateM(Member vo) {
		ser.updateM(vo);
		return "redirect:/admin";
	}
	@GetMapping("/deleteM")
	public String deleteM(int idx) {
		ser.deleteM(idx);
		return "redirect:/admin";
	}
	
}