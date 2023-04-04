package org.iclass.mvc.controller;


import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/register")
	public String insertPage() {
		return "member/register";
	}

	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}

	@GetMapping("/find/{email}")
	@ResponseBody
	public int idcheck(@PathVariable String email) {
		int result = service.idcheck(email);
		return result;
	}
	@GetMapping("/finds/{nickname}")
	@ResponseBody
	public int nickchk(@PathVariable String nickname) {
		int result = service.idcheck(nickname);
		return result;
	}
	
}
