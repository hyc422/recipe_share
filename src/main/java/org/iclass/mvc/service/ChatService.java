package org.iclass.mvc.service;

import java.util.ArrayList;
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
		
		Map<String, String> map = new HashMap<>();
		map.put("roomId", roomId);
		map.put("roomName", roomName);
		
		return dao.createChatRoom(map);
	}	// method end
	
	public int countUser(String roomId)
	{
		return dao.countUser(roomId);
	}
	
	public String enterUser(UserList list)
	{	
		String userId = UUID.randomUUID().toString();
		
		list.setUserId(userId);
		
		dao.enterUser(list);

		return userId;
	}	// method end
	
	public int leaveUser(String userId)
	{
		return dao.leaveUser(userId);
	}	// method end
	
	public ArrayList<String> selectUserList(String roomId)
	{
		ArrayList<String> list = new ArrayList<>();
		
		List<UserList> userList = dao.selectUserListAll(roomId);
		
		userList.forEach((UserList u) -> list.add(u.getNickName()));
		
		return list;
	}	// method end

	public UserList selectUserListOne(String roomId, String userId)
	{
		Map<String, String> map = new HashMap<>();
		map.put("roomId", roomId);
		map.put("userId", userId);
		
		return dao.selectUserListOne(map);
	}

	public int deleteChatRoom(String roomId) 
	{
		return dao.deleteChatRoom(roomId);
	}	// method end
}	// Class end
