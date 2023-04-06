package org.iclass.mvc.controller;


import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/register")
	public String insertPage() {
		return "member/register";
	}

	@PostMapping("/register")
	public String register(Member vo,@RequestParam(name="phone1",required = false)String phone1,@RequestParam("phone2")String phone2,@RequestParam("phone3")String phone3) {
		String phone = phone1 + "-" + phone2 + "-" +phone3;
		vo.setPhone(phone);
		service.register(vo);
		return "redirect:/";
	}

	@GetMapping("/find/{email}")
	@ResponseBody
	public int idcheck(@PathVariable String email) {
		int result = service.emcheck(email);
		return result;
	}
	@GetMapping("/finds/{nickname}")
	@ResponseBody
	public int nickchk(@PathVariable String nickname) {
		int result = service.nickchk(nickname);
		return result;
	}

	@GetMapping("/findUser")
	public String findUserPop() {
		return "findUser";
	}
}
