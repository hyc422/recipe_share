package org.iclass.mvc.controller;

import java.util.List;

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
		service.plusUserCnt(chat.getRoomId());
		
		String userUUID = service.enterUser(chat.getRoomId(), chat.getSender());
		
		headerAcceccor.getSessionAttributes().put("userUUID", userUUID);
		headerAcceccor.getSessionAttributes().put("roomId", chat.getRoomId());
		
		chat.setMessage(chat.getSender() + "님 입장");
		template.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
	}	// method end
	
	@MessageMapping("/chat/sendMessage")
	public void sendMessage(@Payload Chat chat)
	{
		log.info("chat : {}",chat);
		chat.setMessage(chat.getMessage());
		template.convertAndSend("/sub/chat/room/" + chat.getRoomId(), chat);
	}	// method end
	
	@EventListener
	public void webSocketDisconnetListner(SessionDisconnectEvent event)
	{
		log.info("DisConnEvnet : {}",event);
		
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String userUUId = (String) headerAccessor.getSessionAttributes().get("userUUID");
		String roomId = (String) headerAccessor.getSessionAttributes().get("roomId");
		
		log.info("headAccssor : {}", headerAccessor);
		
		service.minusUserCnt(roomId);
		
		String nickName = service.selectUserListOne(roomId, userUUId).getNickName();
		service.leaveUser(userUUId);
		
		if(nickName!=null)
		{
			log.info("User Disconnected : {}",nickName);
		
			Chat chat = Chat.builder()
							.type(Chat.MessageType.LEAVE)
							.sender(nickName)
							.message(nickName + " 님 퇴장")
							.build();
		
			template.convertAndSend("/sub/chat/room/" + roomId, chat);
		}
	}	// method end
	
	@GetMapping("/chat/userlist")
	@ResponseBody
	public List<UserList> userList(String roomId)
	{
		return service.selectUserList(roomId);
	}	// method end
}	// Class end
