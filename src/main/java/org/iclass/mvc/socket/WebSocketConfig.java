package org.iclass.mvc.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(alertHandler(), "/alarm")	//첫번째이자 핸들러가 /alarm 요청 처리
		.setAllowedOrigins("http://localhost:8082"); //url은 소켓통신을 사용 할 서버주소
		// /alarm 소켓통신의 endpoint 
	}
	
	@Bean		//bean(객체로 생성 됨.)
	public AlertHandler alertHandler() {
		return new AlertHandler();
	}

}
