package org.iclass.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat
{
    // 메시지  타입 : 입장, 채팅
    // 메시지 타입 : 동작하는 구조
    // 입장(ENTER) 퇴장(LEAVE)의 경우 입장/퇴장 이벤트 처리가 실행
    // TALK는 내용이 해당 채팅방을 SUB 하고 있는 모든 클라이언트에게 전달
    public enum MessageType {ENTER, TALK, LEAVE;}
    private MessageType type; 	// 메시지 타입
    private String roomId; 		// 방 번호
    private String sender; 		// 채팅을 보낸 사람
    private String message; 	// 메시지
    private String time; 		// 채팅 발송 시간
}	// Class end
