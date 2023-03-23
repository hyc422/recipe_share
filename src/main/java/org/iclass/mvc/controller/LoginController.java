package org.iclass.mvc.controller;


import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final MemberService service;
	
	@GetMapping("/login")
	public void loginPage() {
		
	}
	@PostMapping("/login")
	public String login(@RequestParam("id")String id,@RequestParam("password") String password,
			HttpSession session) {
		Member member = service.login(id,password);
		if(member == null) {
		}	else {
			session.setAttribute("member", member);
		}
		return "redirect:/";		
	}
}
