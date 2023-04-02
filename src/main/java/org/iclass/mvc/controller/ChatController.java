package org.iclass.mvc.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController 
{
	private final SimpMessageSendingOperations template;

	public ChatController(SimpMessageSendingOperations template) 
	{this.template = template;}
	
	@MessageMapping("/chat/enterUser")
	public void enterUser(@Payload)
}	// Class end
