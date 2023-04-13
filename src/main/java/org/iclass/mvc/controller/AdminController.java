package org.iclass.mvc.controller;


import java.time.LocalDate;

import org.iclass.mvc.dto.Board;
import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.BoardService;
import org.iclass.mvc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AdminController {
	
	private final IndexService ser;
	private final BoardService ser2;
	@GetMapping("/admin")
	public void admin(Model model) {
		model.addAttribute("list", ser.listAll());
		model.addAttribute("today", LocalDate.now());	
		model.addAttribute("Alist", ser.announcementList());	
		model.addAttribute("member", ser.memberAll());
		
	}
	@GetMapping("/deleteAdmin")
	public String deleteAdmin(int idx) {
		ser2.delete(idx);
		return "redirect:/admin";
	}
	@PostMapping("/Awrite")
	public String write(Board vo){
		ser2.create(vo);
		return "redirect:/admin";
		

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