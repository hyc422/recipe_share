package org.iclass.mvc.controller;

import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MyPageApiController 
{
	private MemberService service;
	private ObjectMapper objMapper = new ObjectMapper();
	
	public MyPageApiController(MemberService service)
	{this.service = service;}
	
	// member update
	@PutMapping("/info/update/{id}")
	public String update(@PathVariable String id, @RequestBody String member, HttpSession session) throws JsonMappingException, JsonProcessingException
	{
		Member dto = objMapper.readValue(member, Member.class);
		
		log.info("Member dto : {}",dto);
		
		int count = service.update(dto);
		
		return objMapper.writeValueAsString(count);
	}	// method end
	
	// password check
	@GetMapping("info/chkPw/{id}")
	public String chkPw(@PathVariable String id, @RequestParam("password") String password, Model model)
	{
		return null;
	} // method end;
	
	// password update
	@PutMapping("/info/chgPw/{id}")
	public void chgpw(@PathVariable String id)
	{
		
	}	// method end
}	// Class end
