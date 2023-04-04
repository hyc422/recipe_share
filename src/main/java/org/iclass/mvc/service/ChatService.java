package org.iclass.mvc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.iclass.mvc.dao.ChatMapper;
import org.iclass.mvc.dto.ChatRoom;
import org.iclass.mvc.dto.UserList;
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
	
	public ChatRoom selectOne(String roomId)
	{
		return dao.selectOne(roomId);
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
	
	public String enterUser(String roomId, String nickname)
	{	
		String userId = UUID.randomUUID().toString();

		dao.enterUser(userId, roomId, nickname);

		return userId;
	}	// method end
	
	public int leaveUser(String userId)
	{
		return dao.leaveUser(userId);
	}	// method end
	
	public List<UserList> selectUserList(String roomId)
	{
		return dao.selectUserListAll(roomId);
	}	// method end

	public UserList selectUserListOne(String roomId, String userId)
	{
		Map<String, String> map = new HashMap<>();
		map.put("roomId", roomId);
		map.put("userId", userId);
		
		return dao.selectUserListOne(map);
	}	// method end
}	// Class end
