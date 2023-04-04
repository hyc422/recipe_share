package org.iclass.mvc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.mvc.dto.ChatRoom;
import org.iclass.mvc.dto.UserList;

@Mapper
public interface ChatMapper 
{
	List<ChatRoom> selectAll();
	ChatRoom selectOne(String roomName);
	int createChatRoom(String roomId, String roomName);
	int plusUserCnt(String roomId);
	int minusUserCnt(String roomId);
	int enterUser(String userId, String roomId, String nickName);
	int leaveUser(String userId);
	List<UserList> selectUserListAll(String roomId);
	UserList selectUserListOne(Map<String, String> map);
}	// Class end
