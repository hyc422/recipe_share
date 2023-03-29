package org.iclass.mvc.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlertHandler extends TextWebSocketHandler {
	
	
	//소켓 연결이 이루어진 후에 할일 처리 - 새로운 클라이언트가 생겼다는 의미
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("새로운 클라이언트 : {}",session);	//지금까지 세션은 http 프로토콜 세션, 전달받는 세션은 소켓세션
		}
	
	//소켓 연결이 해제 된 후에 할일 처리
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("접속 해제 클라이언트 : {}",session);	
	}
	
	//데이터 송수신과 발생했을 때 처리하는 메소드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("데이터를 보낸 클라이언트 : {}",session);
		log.info("받은 메세지 : {}",message.getPayload());
	}
}
