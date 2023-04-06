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
	ChatRoom selectOne(String roomId);
	int createChatRoom(Map<String, String> map);
	int enterUser(UserList list);
	int leaveUser(String userId);
	int countUser(String roomId);
	List<UserList> selectUserListAll(String roomId);
	UserList selectUserListOne(Map<String, String> map);
}	// Class end
