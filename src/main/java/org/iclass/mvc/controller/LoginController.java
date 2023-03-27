package org.iclass.mvc.controller;


import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
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
		
		log.info("Member : {}",member);
		
		return "redirect:/";		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
