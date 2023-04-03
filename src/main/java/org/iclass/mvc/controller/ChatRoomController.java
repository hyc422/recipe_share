package org.iclass.mvc.controller;

import org.iclass.mvc.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatRoomController 
{
	private final ChatService service;

	public ChatRoomController(ChatService service) 
	{this.service = service;}
	
	@GetMapping("/chat")
	public String chat(Model model)
	{
		model.addAttribute("list", service.selectAll());
		
		log.info("chatroom list : {}", service.selectAll());
		
		return "roomlist";
	}	// method end
	
	@PostMapping("/chat/createroom")
	public String createRoom(@RequestParam String name, RedirectAttributes rttr)
	{
		String message;
		
		if(service.createChatRoom(name) == 1)
			message = "생성 완료";
		else
			message = "생성 실패";
		
		rttr.addFlashAttribute("message",message);
		
		return "redirect:/chat";
	}	// method end
	
	@GetMapping("/chat/room")
	public String chatRoom(Model model, String roomId)
	{
		model.addAttribute("room", service.selectOne(roomId));
		
		return "chat/room";
	}	// method end
}	// Class end
