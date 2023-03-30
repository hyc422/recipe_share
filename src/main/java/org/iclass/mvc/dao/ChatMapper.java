package org.iclass.mvc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.ChatRoom;

@Mapper
public interface ChatMapper 
{
	List<ChatRoom> selectAll();
	ChatRoom selectOne(String roomName);
	int createChatRoom(String roomName);
	int createChatRoom(String roomId, String roomName);
	int plusUserCnt(String roomId);
	int minusUserCnt(String roomId);
	int enterUser(String nickname);
}	// Class end
