package org.iclass.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Stomp 를 통해 pub/sub 를 사용하면 구독자 관리가 자동
// 따라서 따로 세션 관리를 하는 코드를 작성할 필도 없고,
// 메시지를 다른 세션의 클라이언트에게 발송하는 것도 구현 필요가 없음
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom 
{
	private String roomId; 		// roomId = nickname
	private String roomName; 	// roomName
	private long userCount; 	// userCount
	private UserList userlist;	// userList
	private int maxUserCnt;		// 
	private String roomPwd;
	private boolean sceretChk;
}	// Class end
