package org.iclass.mvc.service;

import java.util.List;
import java.util.UUID;

import org.iclass.mvc.dao.ChatMapper;
import org.iclass.mvc.dto.ChatRoom;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService 
{
	private final ChatMapper dao;
	
	public List<ChatRoom> selectAll()
	{
		return dao.selectAll();
	}	// method end
	
	public ChatRoom selectOne(String roomName)
	{
		return dao.selectOne(roomName);
	}	// method end
	
	public int createChatRoom(String roomName)
	{
		String roomId = UUID.randomUUID().toString();
		return dao.createChatRoom(roomId,roomName);
	}	// method end
	
	public int plusUserCnt(String roomId)
	{
		return dao.plusUserCnt(roomId);
	}	// method end
	
	public int minusUserCnt(String roomId)
	{
		return dao.minusUserCnt(roomId);
	}	// method end
	
	public int enterUser(String nickname)
	{
		return dao.enterUser(nickname);
	}	// method end
}	// Class end
