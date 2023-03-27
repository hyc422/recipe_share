package org.iclass.mvc.controller;

import javax.servlet.http.HttpSession;

import org.iclass.mvc.dto.Member;
import org.iclass.mvc.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MypageController 
{
	private MemberService service;
	private ObjectMapper objMapper = new ObjectMapper();
	
	public MypageController(MemberService service)
	{this.service = service;}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable String id, @RequestBody String temp, HttpSession session) throws JsonMappingException, JsonProcessingException
	{
		Member dto = objMapper.readValue(temp, Member.class);
		
		log.info("Member dto : {}",dto);
		
		service.update(dto);
		
	}	// method end
	
	@PutMapping("pwChg/{id}")
	public void pwChg(@PathVariable String id)
	{
		
	}	// method end
}	// Class end
