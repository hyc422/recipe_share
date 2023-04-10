package org.iclass.mvc.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import org.iclass.mvc.dto.Chat;
import org.iclass.mvc.dto.UserList;
import org.iclass.mvc.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController 
{
	private final SimpMessageSendingOperations template;
	
	@Autowired
	ChatService service;
	
	
	@MessageMapping("/chat/enterUser")
	public void enterUser(@Payload Chat chat, SimpMessageHeaderAccessor headerAcceccor)
	{
		log.info("enterUser chat : {}",chat);
		
		UserList list = UserList.builder()
								.roomId(chat.getRoomId())
								.nickName(chat.getSender())
								.build();
		
		String userUUID = service.enterUser(list);
		
		service.countUser(chat.getRoomId());
		
		headerAcceccor.getSessionAttributes().put("userUUID", userUUID);
		headerAcceccor.getSessionAttributes().put("roomId", chat.getRoomId());
		
		chat.setMessage(chat.getSender() + "님 입장");
		template.convertAndSend("/sub/chat/chatroom/" + chat.getRoomId(), chat);
	}	// method end
	
	@MessageMapping("/chat/sendMessage")
	public void sendMessage(@Payload Chat chat)
	{
		chat.setMessage(chat.getMessage());
		
		LocalDateTime date = LocalDateTime.now();
		
		chat.setTime(date.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
		
		
		log.info("chat : {}",chat);
		template.convertAndSend("/sub/chat/chatroom/" + chat.getRoomId(), chat);
	}	// method end
	
	@EventListener
	public void webSocketDisconnetListner(SessionDisconnectEvent event)
	{
		log.info("DisConnEvnet : {}",event);
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String userUUId = (String) headerAccessor.getSessionAttributes().get("userUUID");
		String roomId = (String) headerAccessor.getSessionAttributes().get("roomId");
		
		log.info("headAccssor : {}", headerAccessor);
		
		
		String nickName = service.selectUserListOne(roomId, userUUId).getNickName();
		service.leaveUser(userUUId);
		
		service.countUser(roomId);
		
		if(nickName!=null)
		{
			log.info("User Disconnected : {}",nickName);
		
			Chat chat = Chat.builder()
							.type(Chat.MessageType.LEAVE)
							.sender(nickName)
							.message(nickName + " 님 퇴장")
							.build();
		
			template.convertAndSend("/sub/chat/chatroom/" + roomId, chat);
		}
	}	// method end
	
	@GetMapping("/chat/userlist")
	@ResponseBody
	public ArrayList<String> userList(String roomId)
	{
		log.info("userList roomId : {}",roomId);
		
		return service.selectUserList(roomId);
	}	// method end
}	// Class end
