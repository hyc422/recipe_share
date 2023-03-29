/**
 * socketConnect.js : 소켓 라이브러리 사용하여 소캣 통신을 위한 객체를 생성
 * 소켓 변수는 전역 변수
 */
'user strict'
let websocket

//소켓 생성과 정의를 함수
function socket_func(){
	websocket = new WebSocket("ws://localhost:8082/alarm");	//소켓 통신 url을 인자로 전달
	//객체가 통신이 시작 됨
	//소켓의 이벤트(통신 열림, 닫힘, 데이터 수신) 처리 함수를 정의
	websocket.onmessage = on_Message //onmessage는 소켓 이벤트 , 함수 이름 onMessage
	websocket.onopen = on_Open
	websocket.onclose = on_Close 
	
	function on_Open(){
		console.log("소켓 통신이 열림.")
		websocket.send("클라이언트 난"+ id)	//데이터 보내기
	}
	
	function on_Close(){
		console.log('소켓 통신이 닫힘.')
	}
	function on_Message(message){	//message 인자는 서버에서 소켓통신으로 보낸 데이터
	console.log('받은 데이터 : ' + message)
	}
	
}//socket_func() 함수 끝.

if(id != '') socket_func()	//id는 세션의 값으로 로그인이 됐을 때만 소켓통신 시작.

function logout(){
	websocket.close()	//소켓통신 연결종료
	location.href='/logout'
}